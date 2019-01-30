package com.onlinebank.core.manager;


import com.onlinebank.core.data.domain.Water;

public interface IWaterManager {

    void create(Water water) throws IllegalArgumentException;
}
