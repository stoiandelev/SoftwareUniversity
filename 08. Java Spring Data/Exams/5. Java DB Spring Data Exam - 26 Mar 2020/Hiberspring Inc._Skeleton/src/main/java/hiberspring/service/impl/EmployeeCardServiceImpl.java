package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.common.GlobalConstants;
import hiberspring.domain.dto.EmployeeCardSeedDto;
import hiberspring.domain.entity.Employee;
import hiberspring.domain.entity.EmployeeCard;
import hiberspring.repository.EmployeeCardRepository;
import hiberspring.service.EmployeeCardService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.EMPLOYEE_CARDS_FILE_PATH;
import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;

@Service
public class EmployeeCardServiceImpl implements EmployeeCardService {

    private final EmployeeCardRepository employeeCardRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public EmployeeCardServiceImpl(EmployeeCardRepository employeeCardRepository,
                                   Gson gson,
                                   ModelMapper modelMapper,
                                   ValidationUtil validationUtil) {
        this.employeeCardRepository = employeeCardRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }


    @Override
    public Boolean employeeCardsAreImported() {
        return employeeCardRepository.count() > 0;
    }

    @Override
    public String readEmployeeCardsJsonFile() throws IOException {
        return Files
                .readString(Path.of(EMPLOYEE_CARDS_FILE_PATH));
    }

    @Override
    public String importEmployeeCards(String employeeCardsFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

//        EmployeeCardSeedDto[] employeeCardSeedDtos = gson
//                .fromJson(readEmployeeCardsJsonFile(), EmployeeCardSeedDto[].class);

        Arrays.stream(gson
                        .fromJson(readEmployeeCardsJsonFile(), EmployeeCardSeedDto[].class))
                .filter(employeeCardSeedDto -> {
                    boolean isValid = validationUtil.isValid(employeeCardSeedDto)
                            && !cardNumberIsNotExists(employeeCardSeedDto.getNumber());
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Employee Card %s.",
                                    employeeCardSeedDto.getNumber())
                                    : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(employeeCardSeedDto -> modelMapper.map(employeeCardSeedDto, EmployeeCard.class))
                .forEach(employeeCardRepository::save);


        return sb.toString();
    }

    @Override
    public EmployeeCard findByCardNumber(String cardNumber) {
        return employeeCardRepository.findByNumber(cardNumber);
    }

    private boolean cardNumberIsNotExists(String number) {
        return employeeCardRepository.existsByNumber(number);
    }
}
