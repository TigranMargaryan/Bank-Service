package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Gas;
import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.data.model.GasResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IGasManager;
import com.onlinebank.core.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class GasController {

private final IGasManager iGasManager;

private final IUserManager userManager;

    @Autowired
   private ModelMapper modelMapper;

    @Autowired
    public GasController(IGasManager iGasManager, IUserManager userManager) {
        this.iGasManager = iGasManager;
        this.userManager = userManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users/{userId}/gases", method = RequestMethod.POST)
    public Response createGas(@Valid @RequestBody GasResource gasResource, @PathVariable("userId") String userId) throws NotFoundException {

        Gas gas = modelMapper.map(gasResource, Gas.class);

        User user = userManager.getById(userId);

        if (user != null) {
            gas.setUser(user);
        }

        iGasManager.create(gas);

        GasResource createGas =modelMapper.map(gas, GasResource.class);

        return new Response<>(new HashMap<String, GasResource>(){{
           put("gas", createGas);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/gases/{id}", method = RequestMethod.GET)
    public Response getGas(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {
        Gas gas = iGasManager.getByid(id);

        if (gas == null || !gas.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.gas", userId, id);
        }
        GasResource gasResource = modelMapper.map(gas, GasResource.class);

        return new Response<>(new HashMap<String, GasResource>() {{
            put("gas", gasResource);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/gases/{id}", method = RequestMethod.PUT)
    public Response updateGas(@PathVariable("userId") String userId, @PathVariable("id") String id, @Valid @RequestBody GasResource gasResource) throws NotFoundException {
        Gas gas = iGasManager.getByid(id);

        if (gas != null && !gas.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.gas", userId, id);
        }

        modelMapper.map(gasResource, gas);

        iGasManager.update(gas);

        GasResource gasResource1 = modelMapper.map(gas, GasResource.class);

        return new Response<>(new HashMap<String, GasResource>(){{
            put("gas", gasResource1);
        }});
    }
}
