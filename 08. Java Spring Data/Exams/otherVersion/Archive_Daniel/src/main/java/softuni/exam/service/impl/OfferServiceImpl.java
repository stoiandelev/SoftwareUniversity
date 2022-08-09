package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OffersRootSeedDto;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.AgentService;
import softuni.exam.service.ApartmentService;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFERS_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final AgentService agentService;
    private final ApartmentService apartmentService;
    private final ModelMapper modelMapper;
    private final XmlParser xmlParser;
    private final ValidationUtil validationUtil;

    public OfferServiceImpl(OfferRepository offerRepository, AgentService agentService,
                            ApartmentService apartmentService, ModelMapper modelMapper,
                            XmlParser xmlParser, ValidationUtil validationUtil) {
        this.offerRepository = offerRepository;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
        this.modelMapper = modelMapper;
        this.xmlParser = xmlParser;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return this.offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files.readString(Path.of(OFFERS_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {


        StringBuilder stringBuilder = new StringBuilder();

        xmlParser.fromFile(OFFERS_FILE_PATH, OffersRootSeedDto.class).getOffers().stream().filter(offerSeedDto -> {

            boolean isValid = validationUtil.isValid(offerSeedDto)
                    && agentService.findAgentByFirstName(offerSeedDto.getAgent().getName());

            stringBuilder.append(isValid ? String.format("Successfully imported offer %.2f",
                    offerSeedDto.getPrice()) : "Invalid offer").append(System.lineSeparator());

            return isValid;

        }).map(offerSeedDto -> {

            Offer offer = modelMapper.map(offerSeedDto, Offer.class);
            offer.setAgent(agentService.findAgent(offerSeedDto.getAgent().getName()));
            offer.setApartment(apartmentService.findById(offerSeedDto.getApartment().getId()));

            return offer;
        }).forEach(offerRepository::save);


        return stringBuilder.toString();

    }

    @Override
    public String exportOffers() {

        StringBuilder stringBuilder = new StringBuilder();

        offerRepository.findBestOffers().forEach(offer -> stringBuilder.append(String.format("""
                        Agent %s %s with offer №%d:
                          \t-Apartment area: %.2f
                          \t--Town: %s
                          \t---Price: %.2f$
                        """, offer.getAgent().getFirstName(),
                offer.getAgent().getLastName(), offer.getId(), offer.getApartment().getArea(),
                offer.getApartment().getTown().getTownName(),
                offer.getPrice())).append(System.lineSeparator()));

        return stringBuilder.toString();
    }
}
