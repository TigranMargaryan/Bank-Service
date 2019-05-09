package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Electricity;
import com.onlinebank.core.exeption.NotFoundException;

public interface IElectricityManager {

    void create(Electricity electricity) throws IllegalArgumentException;

    void update(Electricity electricity) throws IllegalArgumentException;

    Electricity getById(String id)throws NotFoundException;
}
