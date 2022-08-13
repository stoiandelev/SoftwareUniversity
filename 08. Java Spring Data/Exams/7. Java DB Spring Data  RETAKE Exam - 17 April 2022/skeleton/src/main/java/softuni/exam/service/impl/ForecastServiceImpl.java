package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ForecastSeedRootDto;
import softuni.exam.models.entity.City;
import softuni.exam.models.entity.DaysOfWeek;
import softuni.exam.models.entity.Forecast;
import softuni.exam.repository.ForecastRepository;
import softuni.exam.service.ForecastService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ForecastServiceImpl implements ForecastService {


    public static final String FORECAST_FILE_PATH = "/Users/stoiandelev/1. IntelliJProjects/05. Spring Data/19. Examps/Exams Java DB Spring Data/7. Java DB Spring Data  RETAKE Exam - 17 April 2022/skeleton/src/main/resources/files/xml/forecasts.xml";

    private final ForecastRepository forecastRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final CityServiceImpl cityService;

    public ForecastServiceImpl(ForecastRepository forecastRepository,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil,
                               XmlParser xmlParser,
                               CityServiceImpl cityService) {
        this.forecastRepository = forecastRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.cityService = cityService;
    }

    @Override
    public boolean areImported() {
        return forecastRepository.count() > 0;
    }

    @Override
    public String readForecastsFromFile() throws IOException {
        return Files
                .readString(Path.of(FORECAST_FILE_PATH));
    }

    @Override
    public String importForecasts() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

        xmlParser
                .fromFile(FORECAST_FILE_PATH, ForecastSeedRootDto.class)
                .getForecasts()
                .stream()
                .filter(forecastSeedDto -> {
                    boolean isValid = validationUtil.isValid(forecastSeedDto)
                            && !sameDayAndCityDontExistInDb(forecastSeedDto.getDayOfWeek()
                            , forecastSeedDto.getCity());


                    sb
                            .append(isValid
                                    ? String.format("Successfully import forecast %s - %.2f",
                                    forecastSeedDto.getDayOfWeek(),
                                    forecastSeedDto.getMaxTemperature())
                                    : "Invalid forecast")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(forecastSeedDto -> {
                    Forecast forecast = modelMapper.map(forecastSeedDto, Forecast.class);

                    City city = cityService.getById(forecastSeedDto.getCity());

                    forecast.setCity(city);


                    return forecast;
                })
                .forEach(forecastRepository::save);


        return sb.toString();
    }

    private boolean sameDayAndCityDontExistInDb(DaysOfWeek dayOfWeek, Long city) {
        return forecastRepository.existsByDaysOfWeekAndCityId(dayOfWeek, city);
    }


    @Override
    public String exportForecasts() {
        StringBuilder sb = new StringBuilder();

        forecastRepository
                .sundayForecast()
                .forEach(forecast -> {
                    sb
                            .append(String.format("""
                                            City: %s:
                                            -min temperature: %.2f
                                            --max temperature: %.2f
                                            ---sunrise: %s
                                            ----sunset: %s
                                            """,
                                    forecast.getCity().getCityName(),
                                    forecast.getMinTemperature(),
                                    forecast.getMaxTemperature(),
                                    forecast.getSunrise(),
                                    forecast.getSunset()))
                            .append(System.lineSeparator());
                });


        return sb.toString();
    }
}
