package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.exeption.NotFoundException;

public interface IUserManager {

    User getById(String id) throws NotFoundException;

    void create(User user) throws IllegalArgumentException;

}
