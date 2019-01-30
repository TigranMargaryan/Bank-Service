package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.Gas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface GasRepository extends JpaRepository<Gas, String> {
}
