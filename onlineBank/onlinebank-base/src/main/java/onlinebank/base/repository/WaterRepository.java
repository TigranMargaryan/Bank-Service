package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.Water;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaterRepository extends PagingAndSortingRepository<Water, String > {
    Water findOneById(String id);
}
