package exam.service.impl;

import exam.model.dto.TownSeedRootDto;
import exam.model.entity.Town;
import exam.repository.TownRepository;
import exam.service.TownService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class TownServiceImpl implements TownService {

    private static final String TOWN_FILE_PATH = "src/main/resources/files/xml/towns.xml";

    private final TownRepository townRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    @Autowired
    public TownServiceImpl(TownRepository townRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           XmlParser xmlParser) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;

        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
    }

    @Override
    public boolean areImported() {
        return townRepository.count() > 0;
    }

    @Override
    public String readTownsFileContent() throws IOException {
        return Files.readString(Path.of(TOWN_FILE_PATH));
    }

    @Override
    public String importTowns() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

//        TownSeedRootDto townSeedRootDto = xmlParser
//                .fromFile(TOWN_FILE_PATH, TownSeedRootDto.class);

        xmlParser
                .fromFile(TOWN_FILE_PATH, TownSeedRootDto.class)
                .getTowns()
                .stream()
                .filter(townSeedDto -> {
                    boolean isValid = validationUtil.isValid(townSeedDto);
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Town %s",
                                    townSeedDto.getName())
                                    : "Invalid town")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(townSeedDto -> modelMapper.map(townSeedDto, Town.class))
                .forEach(townRepository::save);

        return sb.toString();
    }

    @Override
    public Town findByName(String name) {
        return townRepository.findByName(name);
    }
}
