package exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Service
public class CustomerServiceImpl implements CustomerService {

    private static final String CUSTOMER_FILE_PATH = "src/main/resources/files/json/customers.json";

    private final CustomerRepository customerRepository;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final Gson gson;

    private final TownServiceImpl townServiceImpl;

    public CustomerServiceImpl(CustomerRepository customerRepository,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil,
                               Gson gson,
                               TownServiceImpl townServiceImpl) {
        this.customerRepository = customerRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.gson = gson;
        this.townServiceImpl = townServiceImpl;
    }

    @Override
    public boolean areImported() {
        return customerRepository.count() > 0;
    }

    @Override
    public String readCustomersFileContent() throws IOException {
        return Files
                .readString(Path.of(CUSTOMER_FILE_PATH));
    }

    @Override
    public String importCustomers() throws IOException {
        StringBuilder sb = new StringBuilder();

//        CustomerSeedDto[] customerSeedDtos = gson
//                .fromJson(readCustomersFileContent(), CustomerSeedDto[].class);

        Arrays.stream(gson
                        .fromJson(readCustomersFileContent(), CustomerSeedDto[].class))
                .filter(customerSeedDto -> {
                    boolean isValid = validationUtil.isValid(customerSeedDto)
                            && !emailNotExistInDb(customerSeedDto.getEmail());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Customer %s %s - %s",
                                    customerSeedDto.getFirstName(),
                                    customerSeedDto.getLastName(),
                                    customerSeedDto.getEmail())
                                    : "Invalid Customer")
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(customerSeedDto -> {
                    Customer customer = modelMapper.map(customerSeedDto, Customer.class);

                    Town town = townServiceImpl.findByName(customerSeedDto.getTown().getName());

                    customer.setTown(town);

                    return customer;
                })
                .forEach(customerRepository::save);


        return sb.toString();
    }

    private boolean emailNotExistInDb(String email) {
        return customerRepository.existsByEmail(email);
    }
}
