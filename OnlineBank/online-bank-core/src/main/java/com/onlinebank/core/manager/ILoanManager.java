package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Loan;

public interface ILoanManager {

    void create(Loan loan) throws IllegalArgumentException;
}
