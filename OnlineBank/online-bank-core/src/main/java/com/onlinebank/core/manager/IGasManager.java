package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Gas;
import com.onlinebank.core.exeption.NotFoundException;

public interface IGasManager {

    void create(Gas gas) throws IllegalArgumentException;

    void update(Gas gas) throws IllegalArgumentException;

    Gas getByid(String id) throws NotFoundException;
}
