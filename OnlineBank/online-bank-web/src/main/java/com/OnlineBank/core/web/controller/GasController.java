package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Gas;
import com.onlinebank.core.data.model.GasResource;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.manager.IGasManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class GasController {

private final IGasManager iGasManager;

    @Autowired
   private ModelMapper modelMapper;

    @Autowired
    public GasController(IGasManager iGasManager) {
        this.iGasManager = iGasManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/gases", method = RequestMethod.POST)
    public Response createGas(@Valid @RequestBody GasResource gasResource){

        Gas gas = modelMapper.map(gasResource, Gas.class);

        iGasManager.create(gas);

        GasResource createGas =modelMapper.map(gas, GasResource.class);

        return new Response<>(new HashMap<String, GasResource>(){{
           put("gas", createGas);
        }});
    }
}
