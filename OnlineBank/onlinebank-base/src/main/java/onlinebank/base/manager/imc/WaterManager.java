package onlinebank.base.manager.imc;

import onlinebank.base.data.domain.Water;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IWaterManager;
import onlinebank.base.repository.WaterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WaterManager implements IWaterManager {

    private final WaterRepository waterRepository;

    @Autowired
    public WaterManager(WaterRepository waterRepository) {
        this.waterRepository = waterRepository;
    }

    @Override
    public void create(Water water) throws IllegalArgumentException {

        if(water == null){
            throw new IllegalArgumentException("Water.null");
        }
        waterRepository.save(water);
    }

    @Override
    public void update(Water gas) throws IllegalArgumentException {
        if (gas == null) {
            throw new IllegalArgumentException("water.null");
        }
        waterRepository.save(gas);
    }

    @Override
    public Water getById(String id) throws NotFoundException {
        Water water = waterRepository.findOneById(id);

        if (water == null) {
            throw new NotFoundException("gas.not.found", id);
        }
        return water;
    }
}
