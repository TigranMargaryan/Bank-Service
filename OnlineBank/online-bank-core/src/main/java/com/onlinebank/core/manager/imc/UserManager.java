package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IUserManager;
import com.onlinebank.core.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManager implements IUserManager {

    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getById(String id) throws NotFoundException {
        User user =userRepository.findOneById(id);


        if (user == null) {
            throw new NotFoundException("user.not.found", id);
        }
        return user;
    }

    @Override
    public void create(User user) throws IllegalArgumentException {

        if (user == null) {
            throw new IllegalArgumentException("user.null");
        }

        userRepository.save(user);
    }
}
