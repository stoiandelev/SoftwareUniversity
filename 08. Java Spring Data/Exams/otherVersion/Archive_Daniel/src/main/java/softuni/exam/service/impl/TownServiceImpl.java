package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.TownRootSeedDto;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TownService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "src/main/resources/files/json/towns.json";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws IOException {

        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(gson.fromJson(readTownsFileContent(), TownRootSeedDto[].class)).filter(townRootSeedDto -> {

                    boolean isValid = validationUtil.isValid(townRootSeedDto);

                    stringBuilder.append(isValid ? String.format("Successfully imported town %s - %d",
                            townRootSeedDto.getTownName(), townRootSeedDto.getPopulation()) : "Invalid town").append(System.lineSeparator());


                    return isValid;

                }).map(townRootSeedDto -> modelMapper.map(townRootSeedDto, Town.class))
                .forEach(townRepository::save);


        return stringBuilder.toString();
    }

    @Override
    public Town findTownByName(String townName) {
        return this.townRepository.findByTownName(townName);
    }
}
