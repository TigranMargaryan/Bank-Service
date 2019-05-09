package onlinebank.base.repository;

import onlinebank.base.data.domain.Electricity;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElectricityRepository extends PagingAndSortingRepository<Electricity, String > {
    Electricity findOneById(String id);
}
