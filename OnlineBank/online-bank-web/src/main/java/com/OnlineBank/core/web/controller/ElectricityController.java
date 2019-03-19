package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Electricity;
import com.onlinebank.core.data.domain.User;
import com.onlinebank.core.data.model.ElectricityResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IElectricityManager;
import com.onlinebank.core.manager.IUserManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class ElectricityController {

    private final IElectricityManager electricityManager;

    private final IUserManager userManager;

    @Autowired
    private ModelMapper modelMapper;



    @Autowired
    public ElectricityController(IElectricityManager electricityManager, IUserManager userManager) {
        this.electricityManager = electricityManager;
        this.userManager = userManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users/{userId}/electricities", method = RequestMethod.POST)
    public Response createElectricity(@Valid @RequestBody ElectricityResource electricityResource, @PathVariable("userId") String userId) throws NotFoundException {

        Electricity electricity = modelMapper.map(electricityResource, Electricity.class);

        User user = userManager.getById(userId);

        if (user != null) {
            electricity.setUser(user);
        }

        electricityManager.create(electricity);

        ElectricityResource createElectricity = modelMapper.map(electricity, ElectricityResource.class);

        return new Response<>(new HashMap<String, ElectricityResource>(){{
            put("electricity", createElectricity);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/electricities/{id}", method = RequestMethod.GET)
    public Response getWater(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {
        Electricity gas = electricityManager.getById(id);

        if (gas == null || !gas.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.gas", userId, id);
        }
        ElectricityResource electricityResource = modelMapper.map(gas, ElectricityResource.class);

        return new Response<>(new HashMap<String, ElectricityResource>() {{
            put("electricity", electricityResource);
        }});
    }
    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/electricities/{id}", method = RequestMethod.PUT)
    public Response updateElectricity(@PathVariable("userId") String userId, @PathVariable("id") String id, @Valid @RequestBody ElectricityResource electricityResource) throws NotFoundException {
        Electricity electricity = electricityManager.getById(id);

        if (electricity != null && !electricity.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.electric", userId, id);
        }

        modelMapper.map(electricityResource, electricity);

        electricityManager.update(electricity);

        ElectricityResource electricityResource1 = modelMapper.map(electricity, ElectricityResource.class);

        return new Response<>(new HashMap<String, ElectricityResource>(){{
            put("electricity", electricityResource1);
        }});
    }
}