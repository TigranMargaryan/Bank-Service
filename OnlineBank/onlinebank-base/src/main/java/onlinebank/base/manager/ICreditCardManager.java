package onlinebank.base.manager;

import onlinebank.base.data.domain.CreditCard;
import onlinebank.base.exeption.NotFoundException;

public interface ICreditCardManager {

    void create(CreditCard creditCard) throws IllegalArgumentException;

    void delete(String userId, String id) throws IllegalArgumentException;

    void update(CreditCard card) throws IllegalArgumentException;

    CreditCard getById(String id) throws NotFoundException;

    CreditCard getByUserId(String userId) throws NotFoundException;

    CreditCard getByIdAndUserId(String id, String userId)throws NotFoundException;

}
