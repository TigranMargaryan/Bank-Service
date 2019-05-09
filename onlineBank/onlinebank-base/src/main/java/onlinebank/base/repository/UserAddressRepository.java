package onlinebank.base.repository;

import onlinebank.base.data.domain.UserAddress;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAddressRepository extends PagingAndSortingRepository<UserAddress, String> {

    UserAddress findOneById(String id);

    UserAddress findOneByUserId(String userId);

    UserAddress findOneByUserIdAndId(String userId, String id);

    int deleteByUserIdAndId(String userId, String id);
}
