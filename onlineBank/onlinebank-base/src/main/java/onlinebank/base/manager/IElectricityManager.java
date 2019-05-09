package onlinebank.base.manager;

import onlinebank.base.data.domain.Electricity;
import onlinebank.base.exeption.NotFoundException;

public interface IElectricityManager {

    void create(Electricity electricity) throws IllegalArgumentException;

    void update(Electricity electricity) throws IllegalArgumentException;

    Electricity getById(String id)throws NotFoundException;
}
