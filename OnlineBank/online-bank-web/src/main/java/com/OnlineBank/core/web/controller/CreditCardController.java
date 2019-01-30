package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.CreditCard;
import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.data.model.CreditCardResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.ICreditCardManager;
import com.onlinebank.core.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class CreditCardController {

    private final ICreditCardManager creditCardManager;

    private final IUserManager userManager;


    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public CreditCardController(ICreditCardManager creditCardManager, IUserManager userManager) {
        this.creditCardManager = creditCardManager;
        this.userManager = userManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/users/{userId}/cards", method = RequestMethod.POST)
    public Response createUser(@Valid @RequestBody CreditCardResource cardResource, @PathVariable("userId") String userId) throws NotFoundException {

        CreditCard card = modelMapper.map(cardResource, CreditCard.class);

        User user = userManager.getById(userId);

        if(user != null){
            card.setUser(user);
        }

        creditCardManager.create(card);

        CreditCardResource createCard = modelMapper.map(card, CreditCardResource.class);

        return new Response<>(new HashMap<String, CreditCardResource>(){{
            put("card", createCard);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/users/{userId}/cards", method = RequestMethod.GET)
    public Response getCreditCardAll(@PathVariable("userId") String userId) throws NotFoundException{

        CreditCard card = creditCardManager.getByUserId(userId);

        CreditCardResource getCard = modelMapper.map(card, CreditCardResource.class);

        return new Response<>(new HashMap<String, CreditCardResource>(){{
            put("card", getCard);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/users/{userId}/cards/{id}", method = RequestMethod.GET)
    public Response getCreditCard(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {

        CreditCard card = creditCardManager.getById(id);

        if(card == null || !card.getUserID().equals(userId)){
            throw new NotFoundException("user.not.have.the.card", userId, id);
        }

        CreditCardResource getCard = modelMapper.map(card, CreditCardResource.class);

        return new Response<>(new HashMap<String, CreditCardResource>(){{
            put("card", getCard);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/users/{userId}/cards/{id}", method = RequestMethod.DELETE)
    public Response deleteCreditcard(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {

        CreditCard card = creditCardManager.getByIdAndUserId(id, userId);

        creditCardManager.delete(id, userId);

        return new Response<>("Accepted");
    }
}
