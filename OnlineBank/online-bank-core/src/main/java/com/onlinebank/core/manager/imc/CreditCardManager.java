package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.CreditCard;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.ICreditCardManager;
import com.onlinebank.core.repository.CreditCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CreditCardManager implements ICreditCardManager {

    private final CreditCardRepository cardRepository;

    @Autowired
    public CreditCardManager(CreditCardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public void create(CreditCard creditCard) throws IllegalArgumentException {
        if(creditCard == null){
            throw new IllegalArgumentException("creditCard.null");
        }

        cardRepository.save(creditCard);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, String userId) throws IllegalArgumentException {
            cardRepository.deleteByUserIdAndId(userId, id);
    }

    @Override
    public CreditCard getById(String id) throws NotFoundException {
        CreditCard card = cardRepository.findOneById(id);

        if(card == null){
            throw  new NotFoundException("Card.not.found", id);
        }

        return card;
    }

    @Override
    public CreditCard getByUserId(String id) throws NotFoundException {

        CreditCard card = cardRepository.findOneByUserId(id);


        if (card == null) {
            throw new NotFoundException("user.not.have.card", id);
        }

        return card;
    }

    @Override
    public CreditCard getByIdAndUserId(String id, String userId) throws NotFoundException {
        CreditCard card = cardRepository.findOneByIdAndUserId(id, userId);

        if (card == null) {
            throw new NotFoundException("user.not.have.card", id);
        }

        return  card;
    }
}
