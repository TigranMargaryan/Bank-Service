package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Gas;

public interface IGasManager {

    void create(Gas gas) throws IllegalArgumentException;
}
