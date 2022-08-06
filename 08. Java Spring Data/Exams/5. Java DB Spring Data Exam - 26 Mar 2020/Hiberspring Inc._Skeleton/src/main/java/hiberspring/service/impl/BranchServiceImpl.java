package hiberspring.service.impl;

import com.google.gson.Gson;
import hiberspring.domain.dto.BranchSeedDto;
import hiberspring.domain.entity.Branch;
import hiberspring.domain.entity.Town;
import hiberspring.repository.BranchRepository;
import hiberspring.service.BranchService;
import hiberspring.service.TownService;
import hiberspring.util.ValidationUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

import static hiberspring.common.GlobalConstants.*;

@Service
public class BranchServiceImpl implements BranchService {

    private final BranchRepository branchRepository;

    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;
    private final TownService townService;

    @Autowired
    public BranchServiceImpl(BranchRepository branchRepository,
                             Gson gson,
                             ModelMapper modelMapper,
                             ValidationUtil validationUtil,
                             TownService townService) {
        this.branchRepository = branchRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
        this.townService = townService;
    }

    @Override
    public Boolean branchesAreImported() {
        return branchRepository.count() > 0;
    }

    @Override
    public String readBranchesJsonFile() throws IOException {
        return Files
                .readString(Path.of(BRANCHES_FILE_PATH));
    }

    @Override
    public String importBranches(String branchesFileContent) throws IOException {
        StringBuilder sb = new StringBuilder();

//        BranchSeedDto[] branchSeedDtos = gson
//                .fromJson(readBranchesJsonFile(), BranchSeedDto[].class);
//
//        System.out.println();

        Arrays.stream(gson
                        .fromJson(readBranchesJsonFile(), BranchSeedDto[].class))
                .filter(branchSeedDto -> {
                    boolean isValid = validationUtil.isValid(branchSeedDto)
                            && !branchNameExist(branchSeedDto.getName());
                    sb
                            .append(isValid
                                    ? String.format(SUCCESSFUL_IMPORT_MESSAGE,
                                    branchSeedDto.getName(),
                                    branchSeedDto.getTown())
                                    : INCORRECT_DATA_MESSAGE)
                            .append(System.lineSeparator());

                    return isValid;
                })
                .map(branchSeedDto -> {

                    Branch branch = modelMapper.map(branchSeedDto, Branch.class);
                    branch.setTown(townService.getTownByName(branchSeedDto.getTown()));

                    return  branch;
                })

                .forEach(branchRepository::save);

        return sb.toString();
    }

    @Override
    public Branch getBranchByName(String name) {
        return branchRepository.findByName(name);
    }

    private boolean branchNameExist(String name) {
        return branchRepository.existsByName(name);
    }
}
