package onlinebank.base.manager;

import onlinebank.base.data.domain.User;
import onlinebank.base.exeption.NotFoundException;

public interface IUserManager {

    User getById(String id) throws NotFoundException;

    User getByUserId(String id) throws NotFoundException;

    void create(User user) throws IllegalArgumentException;

    void delete(String id) throws NotFoundException;

}
