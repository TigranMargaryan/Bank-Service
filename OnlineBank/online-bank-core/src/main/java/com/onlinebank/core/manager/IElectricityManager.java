package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Electricity;

public interface IElectricityManager {

    void create(Electricity electricity) throws IllegalArgumentException;
}
