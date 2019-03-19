package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.Loan;
import com.onlinebank.core.manager.ILoanManager;
import com.onlinebank.core.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoanManager implements ILoanManager {

    private final LoanRepository loanRepository;

    @Autowired
    public LoanManager(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public void create(Loan loan) throws IllegalArgumentException {
        if(loan == null){
            throw new IllegalArgumentException("loan.null");
        }

        if(loan.getUser() == null){
            throw new IllegalArgumentException("user.null");
        }

        if (loan.getUser().getLoan() != null) {
            throw new IllegalArgumentException("user.already.has.loan");
        }

        loanRepository.save(loan);
    }
}
