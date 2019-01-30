package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Branch;
import com.onlinebank.core.data.model.BranchResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.manager.IBranchManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class BranchController {

    private final IBranchManager iBranchManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public BranchController(IBranchManager iBranchManager) {
        this.iBranchManager = iBranchManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/branches", method = RequestMethod.POST)
    public Response createBranch(@Valid @RequestBody BranchResource branchResource){
        Branch branch = modelMapper.map(branchResource, Branch.class);

        iBranchManager.create(branch);

        BranchResource createBranch = modelMapper.map(branch, BranchResource.class);

        return new Response<>(new HashMap<String, BranchResource>(){{
            put("branch", createBranch);
        }});
    }
}
