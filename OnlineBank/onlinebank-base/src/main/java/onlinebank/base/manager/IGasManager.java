package onlinebank.base.manager;

import onlinebank.base.data.domain.Gas;
import onlinebank.base.exeption.NotFoundException;

public interface IGasManager {

    void create(Gas gas) throws IllegalArgumentException;

    void update(Gas gas) throws IllegalArgumentException;

    Gas getByid(String id) throws NotFoundException;
}
