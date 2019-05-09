package onlinebank.base.repository;

import onlinebank.base.data.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    User findOneById(String id);

    User findByUsername(String username);

}
