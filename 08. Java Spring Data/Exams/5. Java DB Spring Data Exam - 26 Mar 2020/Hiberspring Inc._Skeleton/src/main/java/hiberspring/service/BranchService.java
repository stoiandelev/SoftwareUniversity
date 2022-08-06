package hiberspring.service;


import hiberspring.domain.entity.Branch;

import java.io.FileNotFoundException;
import java.io.IOException;


public interface BranchService {

    Boolean branchesAreImported();

    String readBranchesJsonFile() throws IOException;

    String importBranches(String branchesFileContent) throws IOException;

    Branch getBranchByName(String name);
}
