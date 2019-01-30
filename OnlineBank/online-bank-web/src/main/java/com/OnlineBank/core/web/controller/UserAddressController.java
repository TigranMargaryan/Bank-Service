package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.data.domain.UserAddress;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.data.model.UserAddressResource;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IUserAddressManager;
import com.onlinebank.core.manager.IUserManager;
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

        return new Response<>(new HashMap<String, UserAddressResource>(){{
            put("address", createAddress);
        }});
    }
}
