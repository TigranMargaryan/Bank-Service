package onlineBank.web.controller;

import onlinebank.base.data.domain.User;
import onlinebank.base.data.domain.Water;
import onlinebank.base.data.model.Response;
import onlinebank.base.data.model.WaterResource;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IUserManager;
import onlinebank.base.manager.IWaterManager;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@RestController
public class WaterController {

    private final IWaterManager waterManager;

    private final IUserManager userManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    public WaterController(IWaterManager waterManager, IUserManager userManager) {
        this.waterManager = waterManager;
        this.userManager = userManager;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping(value = "api/users/{userId}/waters", method = RequestMethod.POST)
    public Response createWater(@Valid @RequestBody WaterResource waterResource, @PathVariable("userId") String userId) throws NotFoundException {
        Water water = modelMapper.map(waterResource, Water.class);

        User user = userManager.getById(userId);

        if (user != null) {
            water.setUser(user);
        }

        waterManager.create(water);

        WaterResource waterCreate = modelMapper.map(water, WaterResource.class);

        return new Response<>(new HashMap<String, WaterResource>(){{
            put("water", waterCreate);
        }});
    }

    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/waters/{id}", method = RequestMethod.GET)
    public Response getWater(@PathVariable("userId") String userId, @PathVariable("id") String id) throws NotFoundException {
        Water gas = waterManager.getById(id);

        if (gas == null || !gas.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.gas", userId, id);
        }
        WaterResource waterResource = modelMapper.map(gas, WaterResource.class);

        return new Response<>(new HashMap<String, WaterResource>() {{
            put("gas", waterResource);
        }});
    }


    @ResponseStatus(HttpStatus.OK)
    @RequestMapping(value = "api/users/{userId}/waters/{id}", method = RequestMethod.PUT)
    public Response updateWater(@PathVariable("userId") String userId, @PathVariable("id") String id, @Valid @RequestBody WaterResource waterResource) throws NotFoundException {
        Water water = waterManager.getById(id);

        if (water != null && !water.getUserID().equals(userId)) {
            throw new NotFoundException("user.not.have.the.water", userId, id);
        }

        modelMapper.map(waterResource, water);

        waterManager.update(water);

        WaterResource waterResource1 = modelMapper.map(water, WaterResource.class);

        return new Response<>(new HashMap<String, WaterResource>(){{
            put("water", waterResource1);
        }});
    }
}


