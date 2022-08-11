package softuni.exam.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dto.OfferSeedRootDto;
import softuni.exam.models.entity.Agent;
import softuni.exam.models.entity.Apartment;
import softuni.exam.models.entity.Offer;
import softuni.exam.repository.OfferRepository;
import softuni.exam.service.OfferService;
import softuni.exam.util.ValidationUtil;
import softuni.exam.util.XmlParser;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Service
public class OfferServiceImpl implements OfferService {

    private static final String OFFER_FILE_PATH = "src/main/resources/files/xml/offers.xml";

    private final OfferRepository offerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final AgentServiceImpl agentService;
    private final ApartmentServiceImpl apartmentService;

    public OfferServiceImpl(OfferRepository offerRepository,
                            ModelMapper modelMapper,
                            ValidationUtil validationUtil,
                            XmlParser xmlParser,
                            AgentServiceImpl agentService,
                            ApartmentServiceImpl apartmentService) {
        this.offerRepository = offerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.agentService = agentService;
        this.apartmentService = apartmentService;
    }


    @Override
    public boolean areImported() {
        return offerRepository.count() > 0;
    }

    @Override
    public String readOffersFileContent() throws IOException {
        return Files
                .readString(Path.of(OFFER_FILE_PATH));
    }

    @Override
    public String importOffers() throws IOException, JAXBException {
        StringBuilder sb = new StringBuilder();

//        OfferSeedRootDto offerSeedRootDto = xmlParser
//                .fromFile(OFFER_FILE_PATH, OfferSeedRootDto.class);

        xmlParser
                .fromFile(OFFER_FILE_PATH, OfferSeedRootDto.class)
                .getOffers()
                .stream()
                .filter(offerSeedDto -> {
                    boolean isValid = validationUtil.isValid(offerSeedDto)
                            && agentService.findAgentByFirstName(offerSeedDto.getAgent().getName());

                    sb
                            .append(isValid
                                    ? String.format("Successfully imported offer %.2f",
                                    offerSeedDto.getPrice())
                                    : "Invalid offer")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(offerSeedDto -> {
                    Offer offer = modelMapper.map(offerSeedDto, Offer.class);

                    Agent agent = agentService.findByName(offerSeedDto.getAgent().getName());
                    Apartment apartment = apartmentService.getById(offerSeedDto.getApartment().getId());

                    offer.setAgent(agent);
                    offer.setApartment(apartment);


                    return offer;
                })
                .forEach(offerRepository::save);


        return sb.toString();
    }


    @Override
    public String exportOffers() {
        StringBuilder sb = new StringBuilder();

        offerRepository
                .findBestOffer()
                .forEach(offer -> {
                    sb.append(
                                    String.format("""
                                                    Agent %s %s with offer №{%d}:
                                                       \t\t-Apartment area: {%.2f}
                                                       \t\t--Town: {%s}
                                                       \t\t---Price: {%.2f}$
                                                    """,
                                            offer.getAgent().getFirstName(),
                                            offer.getAgent().getLastName(),
                                            offer.getId(),
                                            offer.getApartment().getArea(),
                                            offer.getApartment().getTown().getTownName(),
                                            offer.getPrice()))
                            .append(System.lineSeparator());
                });


        return sb.toString();
    }
}
