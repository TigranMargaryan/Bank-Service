package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Electricity;
import com.onlinebank.core.data.model.ElectricityResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.manager.IElectricityManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class ElectricityController {

    private final IElectricityManager electricityManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public ElectricityController(IElectricityManager electricityManager) {
        this.electricityManager = electricityManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/electricities", method = RequestMethod.POST)
    public Response createElectricity(@Valid @RequestBody ElectricityResource electricityResource) {

        Electricity electricity = modelMapper.map(electricityResource, Electricity.class);

        electricityManager.create(electricity);

        ElectricityResource createElectricity = modelMapper.map(electricity, ElectricityResource.class);

        return new Response<>(new HashMap<String, ElectricityResource>(){{
            put("gas", createElectricity);
        }});
    }
}