package onlinebank.base.manager.imc;

import onlinebank.base.data.domain.User;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IUserManager;
import onlinebank.base.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service(value = "userService")
public class UserManager implements UserDetailsService, IUserManager {

    private final UserRepository userRepository;

    @Autowired
    public UserManager(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User getByUserId(String id) throws NotFoundException {
        User user = userRepository.findOneById(id);


        if (user == null) {
            throw new NotFoundException("user.not.found", id);
        }
        return user;
    }

    @Override
    public User getById(String id) throws NotFoundException {
        User user = userRepository.findOneById(id);


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

    @Override
    public void delete(String id) throws NotFoundException {

        userRepository.deleteById(id);
    }

    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority());
    }

    private List<SimpleGrantedAuthority> getAuthority() {
        return Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"));
    }

}