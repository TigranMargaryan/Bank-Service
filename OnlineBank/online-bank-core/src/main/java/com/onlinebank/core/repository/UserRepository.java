package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String> {

    User findOneById(String id);

}
