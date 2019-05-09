package onlinebank.base.manager.imc;

import onlinebank.base.data.domain.Gas;
import onlinebank.base.exeption.NotFoundException;
import onlinebank.base.manager.IGasManager;
import onlinebank.base.repository.GasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public void update(Gas gas) throws IllegalArgumentException {
        if (gas == null) {
            throw new IllegalArgumentException("address.null");
        }
        gasRepository.save(gas);
    }

    @Override
    public Gas getByid(String id) throws NotFoundException {
        Gas gas = gasRepository.findOneById(id);

        if (gas == null) {
            throw new NotFoundException("gas.not.found", id);
        }
        return gas;
    }
}
