package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.Branch;
import com.onlinebank.core.manager.IBranchManager;
import com.onlinebank.core.repository.BranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BranchManager implements IBranchManager {

    private final BranchRepository branchRepository;

    @Autowired
    public BranchManager(BranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }


    @Override
    public void create(Branch branch) throws IllegalArgumentException {

        if(branch == null){
            throw new IllegalArgumentException("branch.null");
        }

        branchRepository.save(branch);
    }
}
