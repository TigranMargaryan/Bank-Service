package onlineBank.web.controller;

import onlinebank.base.data.domain.User;
import onlinebank.base.data.domain.UserAddress;
import onlinebank.base.data.model.Response;
import onlinebank.base.data.model.UserAddressResource;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IUserAddressManager;
import onlinebank.base.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class UserAddressController {

    private final IUserManager userManager;

    private final IUserAddressManager addressManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public UserAddressController(IUserManager userManager, IUserAddressManager addressManager) {
        this.userManager = userManager;
        this.addressManager = addressManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users/{userId}/addresses", method = RequestMethod.POST)
    public Response createAddress(@Valid @RequestBody UserAddressResource addressResource, @PathVariable("userId") String userId) throws NotFoundException {

        UserAddress userAddress = modelMapper.map(addressResource, UserAddress.class);

        User user = userManager.getById(userId);

        if (user != null) {
            userAddress.setUser(user);
        }

        addressManager.create(userAddress);

        UserAddressResource createAddress = modelMapper.map(userAddress, UserAddressResource.class);

        return new Response<>(new HashMap<String, UserAddressResource>() {{
            put("address", createAddress);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/addresses", method = RequestMethod.GET)
    public Response getAllAddress(@PathVariable("userId") String userId) throws NotFoundException {

        UserAddress userAddress = addressManager.getByUserId(userId);

        UserAddressResource getAddress = modelMapper.map(userAddress, UserAddressResource.class);

        return new Response<>(new HashMap<String, UserAddressResource>() {{
            put("address", getAddress);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/addresses/{id}", method = RequestMethod.GET)
    public Response getAddress(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {
        UserAddress address = addressManager.getById(id);

        if (address == null || !address.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.address", userId, id);
        }
        UserAddressResource getAddress = modelMapper.map(address, UserAddressResource.class);

        return new Response<>(new HashMap<String, UserAddressResource>() {{
            put("address", getAddress);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/addresses/{id}", method = RequestMethod.PUT)
    public Response updateAddress(@PathVariable("userId") String userId, @PathVariable("id") String id, @Valid @RequestBody UserAddressResource addressResource) throws NotFoundException {
        UserAddress address = addressManager.getById(id);

        if (address != null && !address.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.address", userId, id);
        }

        modelMapper.map(addressResource, address);

        addressManager.update(address);

        UserAddressResource addressResource1 = modelMapper.map(address, UserAddressResource.class);

        return new Response<>(new HashMap<String, UserAddressResource>(){{
            put("address", addressResource1);
        }});
    }

    @ResponseStatus(HttpStatus.ACCEPTED)
    @RequestMapping(value = "/api/users/{userId}/addresses/{id}", method = RequestMethod.DELETE)
    public Response deleteAddress(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {
        UserAddress address = addressManager.getByIdAndUserId(id, userId);

        addressManager.delete(id, userId);

        return new Response<>("Accepted");
    }
}