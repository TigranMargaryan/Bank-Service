package onlinebank.base.manager;


import onlinebank.base.data.domain.Water;
import onlinebank.base.exeption.NotFoundException;

public interface IWaterManager {

    void create(Water water) throws IllegalArgumentException;

    void update(Water gas) throws IllegalArgumentException;

    Water getById(String id)throws NotFoundException;
}
