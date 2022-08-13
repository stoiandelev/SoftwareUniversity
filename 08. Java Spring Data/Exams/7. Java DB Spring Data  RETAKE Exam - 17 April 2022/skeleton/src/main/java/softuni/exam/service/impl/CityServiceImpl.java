package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CitySeedDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CityRepository;
import softuni.exam.service.CityService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CityServiceImpl implements CityService {

    public static final String CITY_FILE_PATH = "/Users/stoiandelev/1. IntelliJProjects/05. Spring Data/19. Examps/Exams Java DB Spring Data/7. Java DB Spring Data  RETAKE Exam - 17 April 2022/skeleton/src/main/resources/files/json/cities.json";

    private final CityRepository cityRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    private final CountryServiceImpl countryService;

    public CityServiceImpl(CityRepository cityRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           Gson gson,
                           CountryServiceImpl countryService) {
        this.cityRepository = cityRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.countryService = countryService;
    }

    @Override
    public boolean areImported() {
        return cityRepository.count() > 0;
    }

    @Override
    public String readCitiesFileContent() throws IOException {
        return Files
                .readString(Path.of(CITY_FILE_PATH));
    }

    @Override
    public String importCities() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readCitiesFileContent(), CitySeedDto[].class))
                .filter(citySeedDto -> {
                    boolean isValid = validationUtil.isValid(citySeedDto)
                            && !dontExistInDb(citySeedDto.getCityName());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported city %s - %d",
                                    citySeedDto.getCityName(),
                                    citySeedDto.getPopulation())
                                    : "Invalid city")
                            .append(System.lineSeparator());


                    return isValid;
                })
                .map(citySeedDto -> {
                    City city = modelMapper.map(citySeedDto, City.class);

                    Country country = countryService.getById(citySeedDto.getCountry());

                    city.setCountry(country);

                    return city;
                })
                .forEach(cityRepository::save);


        return sb.toString();
    }

    @Override
    public City getById(Long id) {
        return cityRepository.getById(id);
    }


    private boolean dontExistInDb(String cityName) {
        return cityRepository.existsByCityName(cityName);
    }
}
