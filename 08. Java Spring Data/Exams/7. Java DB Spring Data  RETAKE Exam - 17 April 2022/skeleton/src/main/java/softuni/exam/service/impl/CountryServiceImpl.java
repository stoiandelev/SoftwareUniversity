package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.CountrySeedDto;
import softuni.exam.models.entity.Country;
import softuni.exam.repository.CountryRepository;
import softuni.exam.service.CountryService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CountryServiceImpl implements CountryService {

    public static final String COUNTRY_FILE_PATH = "/Users/stoiandelev/1. IntelliJProjects/05. Spring Data/19. Examps/Exams Java DB Spring Data/7. Java DB Spring Data  RETAKE Exam - 17 April 2022/skeleton/src/main/resources/files/json/countries.json";

    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    public CountryServiceImpl(CountryRepository countryRepository,
                              ModelMapper modelMapper,
                              ValidationUtil validationUtil,
                              Gson gson) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
    }


    @Override
    public boolean areImported() {
        return countryRepository.count() > 0;
    }

    @Override
    public String readCountriesFromFile() throws IOException {
        return Files
                .readString(Path.of(COUNTRY_FILE_PATH));
    }

    @Override
    public String importCountries() throws IOException {
        StringBuilder sb = new StringBuilder();

        Arrays.stream(gson
                        .fromJson(readCountriesFromFile(), CountrySeedDto[].class))
                .filter(countrySeedDto -> {
                    boolean isValid = validationUtil.isValid(countrySeedDto)
                            && !dontExistByCountryName(countrySeedDto.getCountryName());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported country %s - %s",
                                    countrySeedDto.getCountryName(),
                                    countrySeedDto.getCurrency())
                                    : "Invalid country")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(countrySeedDto -> modelMapper.map(countrySeedDto, Country.class))
                .forEach(countryRepository::save);


        return sb.toString();
    }

    private boolean dontExistByCountryName(String countryName) {
        return countryRepository.existsByCountryName(countryName);
    }

    @Override
    public Country getById(Long id) {
        return countryRepository.getById(id);
    }
}
