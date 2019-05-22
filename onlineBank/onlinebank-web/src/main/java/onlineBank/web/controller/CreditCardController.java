package onlineBank.web.controller;

import onlinebank.base.config.ClickatellRest;
import onlinebank.base.data.domain.CreditCard;
import onlinebank.base.data.domain.User;
import onlinebank.base.data.model.CreditCardResource;
import onlinebank.base.data.model.Response;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.ICreditCardManager;
import onlinebank.base.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
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

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/users/{userId}/cards/{id}", method = RequestMethod.PUT)
    public Response updateCard(@PathVariable("userId") String userId, @PathVariable("id") String id, @Valid @RequestBody CreditCardResource cardResource) throws NotFoundException, IOException {
        CreditCard card = creditCardManager.getById(id);


        modelMapper.map(cardResource, card);

        creditCardManager.update(card);

        String message = "Card use";

        String[] x={card.getPhone()};

        ClickatellRest.multipleNumbers(x, message);

        CreditCardResource cardResource1 = modelMapper.map(card, CreditCardResource.class);

        return new Response<>(new HashMap<String, CreditCardResource>(){{
            put("card", cardResource1);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/users/{userId}/cards/{id}", method = RequestMethod.DELETE)
    public Response deleteCreditcard(@PathVariable("userId") String userId, @PathVariable("id") String id)  {

        creditCardManager.delete(id, userId);

        return new Response<>("Accepted");
    }
}
