package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.CreditCard;
import com.onlinebank.core.exeption.NotFoundException;

public interface ICreditCardManager {

    void create(CreditCard creditCard) throws IllegalArgumentException;

    void delete(String userId, String id) throws IllegalArgumentException;

    CreditCard getById(String id) throws NotFoundException;

    CreditCard getByUserId(String userId) throws NotFoundException;

    CreditCard getByIdAndUserId(String id, String userId)throws NotFoundException;

}
