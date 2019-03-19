package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.Electricity;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IElectricityManager;
import com.onlinebank.core.repository.ElectricityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ElectricityManager implements IElectricityManager {

    private final ElectricityRepository electricityRepository;

    @Autowired
    public ElectricityManager(ElectricityRepository electricityRepository) {
        this.electricityRepository = electricityRepository;
    }


    @Override
    public void create(Electricity electricity) throws IllegalArgumentException {

        if(electricity == null){
            throw new IllegalArgumentException("electricity.null");
        }
        electricityRepository.save(electricity);
    }

    @Override
    public void update(Electricity electricity) throws IllegalArgumentException {
        if (electricity == null) {
            throw new IllegalArgumentException("electric.null");
        }
        electricityRepository.save(electricity);
    }

    @Override
    public Electricity getById(String id) throws NotFoundException {
        Electricity electricity = electricityRepository.findOneById(id);

        if (electricity == null) {
            throw new NotFoundException("gas.not.found", id);
        }
        return electricity;
    }
}
