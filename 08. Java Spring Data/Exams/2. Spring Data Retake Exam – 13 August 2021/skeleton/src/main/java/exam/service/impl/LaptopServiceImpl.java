package exam.service.impl;

import com.google.gson.Gson;
import exam.model.dto.LaptopSeedDto;
import exam.model.entity.Laptop;
import exam.model.entity.Shop;
import exam.repository.LaptopRepository;
import exam.service.LaptopService;
import exam.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.stream.Collectors;


@Service
public class LaptopServiceImpl implements LaptopService {

    private static final String LAPTOP_FILE_PATH = "src/main/resources/files/json/laptops.json";

    private final LaptopRepository laptopRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    private final ShopServiceImpl shopServiceIml;

    public LaptopServiceImpl(LaptopRepository laptopRepository,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil,
                             Gson gson,
                             ShopServiceImpl shopServiceIml) {
        this.laptopRepository = laptopRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.shopServiceIml = shopServiceIml;
    }


    @Override
    public boolean areImported() {
        return laptopRepository.count() > 0;
    }

    @Override
    public String readLaptopsFileContent() throws IOException {
        return Files
                .readString(Path.of(LAPTOP_FILE_PATH));
    }

    @Override
    public String importLaptops() throws IOException {
        StringBuilder sb = new StringBuilder();

//        LaptopSeedDto[] laptopSeedDtos = gson
//                .fromJson(readLaptopsFileContent(), LaptopSeedDto[].class);

        Arrays.stream(gson
                        .fromJson(readLaptopsFileContent(), LaptopSeedDto[].class))
                .filter(laptopSeedDto -> {
                    boolean isValid = validationUtil.isValid(laptopSeedDto)
                            && !macAddressNotExistInDb(laptopSeedDto.getMacAddress());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Laptop %s - %.2f - %d - %d",
                                    laptopSeedDto.getMacAddress(),
                                    laptopSeedDto.getCpuSpeed(),
                                    laptopSeedDto.getRam(),
                                    laptopSeedDto.getStorage())
                                    : "Invalid Laptop")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(laptopSeedDto -> {
                    Laptop laptop = modelMapper.map(laptopSeedDto, Laptop.class);

                    Shop shop = shopServiceIml.findByName(laptopSeedDto.getShop().getName());

                    laptop.setShop(shop);

                    return laptop;
                })
                .forEach(laptopRepository::save);


        return sb.toString();
    }

    private boolean macAddressNotExistInDb(String macAddress) {
        return laptopRepository.existsByMacAddress(macAddress);
    }

    @Override
    public String exportBestLaptops() {
        return laptopRepository.findAllByOrderByCpuSpeedDescRamDescStorageDescMacAddressAsc()
                .stream()
                .map(l -> String.format("Laptop - %s%n" +
                                "*Cpu speed - %.2f%n" +
                                "**Ram - %d%n" +
                                "***Storage - %d%n" +
                                "****Price - %.2f%n" +
                                "#Shop name - %s%n" +
                                "##Town - %s%n",
                        l.getMacAddress(),
                        l.getCpuSpeed(),
                        l.getRam(),
                        l.getStorage(),
                        l.getPrice(),
                        l.getShop().getName(),
                        l.getShop().getTown().getName()))
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
