package onlinebank.base.repository;

import onlinebank.base.data.domain.Gas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GasRepository extends JpaRepository<Gas, String> {
    Gas findOneById(String id);
}
