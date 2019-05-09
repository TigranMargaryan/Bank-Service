package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.exeption.NotFoundException;
import org.springframework.security.core.userdetails.UserDetails;

public interface IUserManager {

    User getById(String id) throws NotFoundException;

    User getByUserId(String id) throws NotFoundException;

    void create(User user) throws IllegalArgumentException;

    void delete(String id) throws NotFoundException;

}
