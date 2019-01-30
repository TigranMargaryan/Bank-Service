package com.OnlineBank.core.web.controller;

import com.onlinebank.core.data.domain.Water;
import com.onlinebank.core.data.model.Response;
import com.onlinebank.core.data.model.WaterResource;
import com.onlinebank.core.manager.IWaterManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class WaterController {

    private final IWaterManager waterManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public WaterController(IWaterManager waterManager) {
        this.waterManager = waterManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "/waters", method = RequestMethod.POST)
    public Response createWater(@Valid @RequestBody WaterResource waterResource){
        Water water = modelMapper.map(waterResource, Water.class);

        waterManager.create(water);

        WaterResource waterCreate = modelMapper.map(water, WaterResource.class);

        return new Response<>(new HashMap<String, WaterResource>(){{
            put("water", waterCreate);
        }});
    }
}


