package hiberspring.service.impl;

import hiberspring.domain.dto.EmployeeSeedRootDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Employee;
import hiberspring.domain.entity.EmployeeCard;
import hiberspring.repository.EmployeeRepository;
import hiberspring.service.BranchService;
import hiberspring.service.EmployeeCardService;
import hiberspring.service.EmployeeService;
import hiberspring.util.ValidationUtil;
import hiberspring.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

import static hiberspring.common.GlobalConstants.EMPLOYEES_FILE_PATH;
import static hiberspring.common.GlobalConstants.INCORRECT_DATA_MESSAGE;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final XmlParser xmlParser;
    private final BranchService branchService;
    private final EmployeeCardService employeeCardService;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               ModelMapper modelMapper,
                               ValidationUtil validationUtil,
                               XmlParser xmlParser,
                               BranchService branchService,
                               EmployeeCardService employeeCardService) {
        this.employeeRepository = employeeRepository;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.xmlParser = xmlParser;
        this.branchService = branchService;
        this.employeeCardService = employeeCardService;
    }


    @Override
    public Boolean employeesAreImported() {
        return employeeRepository.count() > 0;
    }

    @Override
    public String readEmployeesXmlFile() throws IOException {
        return Files
                .readString(Path.of(EMPLOYEES_FILE_PATH));
    }

    @Override
    public String importEmployees() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

//        EmployeeSeedRootDto employeeSeedRootDto = xmlParser
//                .fromFile(EMPLOYEES_FILE_PATH, EmployeeSeedRootDto.class);

        xmlParser
                .fromFile(EMPLOYEES_FILE_PATH, EmployeeSeedRootDto.class)
                .getEmployees()
                .stream()
                .filter(employeeSeedDto -> {
                    boolean isValid = validationUtil.isValid(employeeSeedDto);
                    sb
                            .append(isValid
                                    ? String.format("Successfully imported Employee %s %s.",
                                    employeeSeedDto.getFirstName(),
                                    employeeSeedDto.getLastName())
                                    : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());
                    return isValid;
                })
                .map(employeeSeedDto -> {
                    Employee employee = modelMapper.map(employeeSeedDto, Employee.class);

                    Branch branch = branchService.getBranchByName(employeeSeedDto.getBranch());
                    EmployeeCard employeeCard = employeeCardService.findByCardNumber(employeeSeedDto.getCard());

                    employee.setBranch(branch);
                    employee.setCard(employeeCard);

                    return employee;
                })
                .forEach(employeeRepository::save);


        return sb.toString();
    }

    @Override
    public String exportProductiveEmployees() {
        return employeeRepository
                .findAllByBranchWithMoreThanOneProduct()
                .stream()
                .map(employee -> {
                    return String.format("Name: %s %s\n" +
                            "Position: %s\n" +
                            "Card Number: %s\n",
                            employee.getFirstName(),
                            employee.getLastName(),
                            employee.getPosition(),
                            employee.getCard().getNumber());
                })
                .collect(Collectors.joining("-------------------------\n"));

    }
}
