package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.Electricity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityRepository extends PagingAndSortingRepository<Electricity, String > {
    Electricity findOneById(String id);
}
