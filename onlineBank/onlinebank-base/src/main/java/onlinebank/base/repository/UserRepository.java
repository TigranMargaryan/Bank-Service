package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findOneById(String id);

    User findByUsername(String username);

}
