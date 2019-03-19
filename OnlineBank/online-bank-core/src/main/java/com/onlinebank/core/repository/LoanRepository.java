package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.Loan;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends PagingAndSortingRepository<Loan, String> {
}
