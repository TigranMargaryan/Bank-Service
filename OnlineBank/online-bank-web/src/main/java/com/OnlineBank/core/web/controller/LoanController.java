package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Loan;
import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.data.model.LoanResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.ILoanManager;
import com.onlinebank.core.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class LoanController {

    private final IUserManager userManager;

    private final ILoanManager loanManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public LoanController(IUserManager userManager, ILoanManager loanManager) {
        this.userManager = userManager;
        this.loanManager = loanManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users/{userId}/loans", method = RequestMethod.POST)
    public Response createLoan(@Valid @RequestBody LoanResource loanResource, @PathVariable("userId") String userId) throws NotFoundException {
        Loan loan = modelMapper.map(loanResource, Loan.class);

        User user = userManager.getById(userId);

        if (user != null) {
            loan.setUser(user);
        }

        loanManager.create(loan);

        LoanResource newLoan = modelMapper.map(loan, LoanResource.class);

        return new Response<>(new HashMap<String, LoanResource>(){{
            put("loan", newLoan);
        }});
    }
}
