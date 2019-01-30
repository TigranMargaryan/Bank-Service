package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.Gas;
import com.onlinebank.core.manager.IGasManager;
import com.onlinebank.core.repository.GasRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class GasManager implements IGasManager {

    private final GasRepository gasRepository;

    @Autowired
    public GasManager(GasRepository gasRepository) {
        this.gasRepository = gasRepository;
    }


    @Override
    public void create(Gas gas) throws IllegalArgumentException{

        if(gas == null){

            throw new IllegalArgumentException("gas.null");
        }

        gasRepository.save(gas);
    }
}
