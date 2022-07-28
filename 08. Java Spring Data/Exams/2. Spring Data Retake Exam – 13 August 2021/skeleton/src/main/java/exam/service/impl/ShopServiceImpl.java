package exam.service.impl;

import exam.model.dto.ShopSeedRootDto;
import exam.model.entity.Shop;
import exam.model.entity.Town;
import exam.repository.ShopRepository;
import exam.service.ShopService;
import exam.util.ValidationUtil;
import exam.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Service
public class ShopServiceImpl implements ShopService {


    private static final String SHOP_FILE_PATH = "src/main/resources/files/xml/shops.xml";

    private final ShopRepository shopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;

    private final TownServiceImpl townServiceImpl;

    public ShopServiceImpl(ShopRepository shopRepository,
                           ModelMapper modelMapper,
                           ValidationUtil validationUtil,
                           XmlParser xmlParser,
                           TownServiceImpl townServiceImpl) {
        this.shopRepository = shopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.townServiceImpl = townServiceImpl;
    }


    @Override
    public boolean areImported() {
        return shopRepository.count() > 0;
    }

    @Override
    public String readShopsFileContent() throws IOException {
        return Files
                .readString(Path.of(SHOP_FILE_PATH));
    }

    @Override
    public String importShops() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

//        ShopSeedRootDto shopSeedRootDto = xmlParser
//                .fromFile(SHOP_FILE_PATH, ShopSeedRootDto.class);

        xmlParser
                .fromFile(SHOP_FILE_PATH, ShopSeedRootDto.class)
                .getShops()
                .stream()
                .filter(shopSeedDto -> {
                    boolean isValid = validationUtil.isValid(shopSeedDto)
                            && !shopNameNotInDb(shopSeedDto.getName());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Shop %s - %.0f",
                                    shopSeedDto.getName(),
                                    shopSeedDto.getIncome())
                                    : "Invalid shop")
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(shopSeedDto -> {
                    Shop shop = modelMapper.map(shopSeedDto, Shop.class);

                    Town town = townServiceImpl.findByName(shopSeedDto.getTownName().getName());
                    shop.setTown(town);

                    return shop;
                })
                .forEach(shopRepository::save);


        return sb.toString();
    }

    @Override
    public Shop findByName(String name) {
        return shopRepository.findByName(name);
    }

    private boolean shopNameNotInDb(String name) {
        return shopRepository.existsByName(name);
    }
}
