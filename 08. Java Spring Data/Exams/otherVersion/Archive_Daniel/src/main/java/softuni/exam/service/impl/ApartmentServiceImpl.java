package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.ApartmentRootSeedDto;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Town;
import softuni.exam.repository.ApartmentRepository;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.TownService;
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
    private final TownService townService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public ApartmentServiceImpl(ApartmentRepository apartmentRepository,
                                TownService townService, ModelMapper modelMapper,
                                XmlParser xmlParser, ValidationUtil validationUtil) {
        this.apartmentRepository = apartmentRepository;
        this.townService = townService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }


    @Override
    public boolean areImported() {
        return this.apartmentRepository.count() > 0;
    }

    @Override
    public String readApartmentsFromFile() throws IOException {
        return Files.readString(Path.of(APARTMENT_FILE_PATH));
    }

    @Override
    public String importApartments() throws IOException, JAXBException {

        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(APARTMENT_FILE_PATH, ApartmentRootSeedDto.class).getApartments().stream().filter(apartmentSeedDto -> {


            boolean isValid = validationUtil.isValid(apartmentSeedDto)
                    && !isExistsTownAndArea(townService.findTownByName(apartmentSeedDto.getTownName()), apartmentSeedDto.getArea());

            stringBuilder.append(isValid ? String.format("Successfully imported apartment %s - %.2f",
                            apartmentSeedDto.getApartmentType(), apartmentSeedDto.getArea()) : "Invalid apartment")
                    .append(System.lineSeparator());

            return isValid;

        }).map(apartmentSeedDto -> {

            Apartment apartment = modelMapper.map(apartmentSeedDto, Apartment.class);
            apartment.setTown(townService.findTownByName(apartmentSeedDto.getTownName()));


            return apartment;

        }).forEach(apartmentRepository::save);


        return stringBuilder.toString();

    }

    @Override
    public Apartment findById(Long id) {
        return apartmentRepository.getById(id);
    }

    private boolean isExistsTownAndArea(Town town, double area) {
        return apartmentRepository.existsByTownAndArea(town, area);
    }
}
