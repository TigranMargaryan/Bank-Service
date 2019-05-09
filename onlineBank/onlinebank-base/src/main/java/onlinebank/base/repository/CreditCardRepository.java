package com.onlinebank.core.repository;

import com.onlinebank.core.data.domain.CreditCard;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditCardRepository extends PagingAndSortingRepository<CreditCard, String> {

    CreditCard findOneByUserId(String id);
    CreditCard findOneById(String id);
    CreditCard findOneByIdAndUserId(String id, String userId);
    int deleteByUserIdAndId(String userId, String id);
}
