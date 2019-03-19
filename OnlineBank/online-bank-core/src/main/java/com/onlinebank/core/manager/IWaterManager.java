package com.onlinebank.core.manager;


import com.onlinebank.core.data.domain.Water;
import com.onlinebank.core.exeption.NotFoundException;

public interface IWaterManager {

    void create(Water water) throws IllegalArgumentException;

    void update(Water gas) throws IllegalArgumentException;

    Water getById(String id)throws NotFoundException;
}
