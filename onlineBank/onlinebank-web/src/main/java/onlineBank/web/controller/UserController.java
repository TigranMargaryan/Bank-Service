package onlineBank.web.controller;

import onlinebank.base.data.domain.User;
import onlinebank.base.data.model.Response;
import onlinebank.base.data.model.UserResource;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class UserController {

    private final IUserManager userManager;

    @Autowired
    private ModelMapper modelMapper;


    @Autowired
    public UserController(IUserManager userManager) {
        this.userManager = userManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users", method = RequestMethod.POST)
    public Response createUser(@Valid @RequestBody UserResource userResource){

        User user = modelMapper.map(userResource, User.class);

        userManager.create(user);

        UserResource createUser = modelMapper.map(user, UserResource.class);

        return  new Response<>(new HashMap<String, UserResource>() {{
            put("user", createUser);
        }});
    }

  @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "/api/users/{id}", method = RequestMethod.GET)
    public Response getUser(@PathVariable("id") String id) throws NotFoundException{
        User user = userManager.getByUserId(id);

        UserResource userResource = modelMapper.map(user, UserResource.class);

        return new Response<>(new HashMap<String, UserResource>() {{
            put("user", userResource);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "api/users/{id}", method = RequestMethod.DELETE)
    public Response deleteUser(@PathVariable("id") String id) throws NotFoundException {
        userManager.delete(id);

        return new Response<>("Deleted");
    }

}
