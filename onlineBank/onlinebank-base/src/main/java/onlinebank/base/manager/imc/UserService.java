package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findOne(long id);
    void delete(long id);
}
