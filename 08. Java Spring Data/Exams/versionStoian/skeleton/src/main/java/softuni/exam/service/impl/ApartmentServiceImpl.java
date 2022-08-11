package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentSeedRootDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ApartmentServiceImpl implements ApartmentService {

    private static final String APARTMENT_FILE_PATH = "src/main/resources/files/xml/apartments.xml";

    private final ApartmentRepository apartmentRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final TownServiceImpl townService;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository,
                                ModelMapper modelMapper,
                                ValidationUtil validationUtil,
                                XmlParser xmlParser,
                                TownServiceImpl townService) {
        this.apartmentRepository = apartmentRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townService = townService;
    }

    @Override
    public boolean areImported() {
        return apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files
                .readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

//        ApartmentSeedRootDto apartmentSeedRootDto = xmlParser
//                .fromFile(APARTMENT_FILE_PATH, ApartmentSeedRootDto.class);

        xmlParser
                .fromFile(APARTMENT_FILE_PATH, ApartmentSeedRootDto.class)
                .getApartments()
                .stream()
                .filter(apartmentSeedDto -> {
                    boolean isValid = validationUtil.isValid(apartmentSeedDto)
                            && !townAndAreaDontExistInDb(townService.
                            findByTownName(apartmentSeedDto.getTown()), apartmentSeedDto.getArea());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported apartment %s - %.2f",
                                    apartmentSeedDto.getApartmentType(),
                                    apartmentSeedDto.getArea())
                                    : "Invalid apartment")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(apartmentSeedDto -> {
                    Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);

                    Town town = townService.findByTownName(apartmentSeedDto.getTown());

                    apartment.setTown(town);

                    return apartment;
                })
                .forEach(apartmentRepository::save);


        return sb.toString();
    }

    @Override
    public Apartment getById(Long id) {
        return apartmentRepository.getById(id);
    }


    private boolean townAndAreaDontExistInDb(Town byTownName, Double area) {
        return apartmentRepository.existsByTownAndArea(byTownName, area);
    }
}
