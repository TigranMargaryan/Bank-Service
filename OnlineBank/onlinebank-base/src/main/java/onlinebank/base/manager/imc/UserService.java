package onlinebank.base.manager.imc;

import onlinebank.base.data.domain.User;

import java.util.List;

public interface UserService {
    User save(User user);
    List<User> findAll();
    User findOne(long id);
    void delete(long id);
}
