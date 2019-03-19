package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.UserAddress;
import com.onlinebank.core.exeption.NotFoundException;
import com.onlinebank.core.manager.IUserAddressManager;
import com.onlinebank.core.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserAddressManager implements IUserAddressManager {

    private final UserAddressRepository addressRepository;

    @Autowired
    public UserAddressManager(UserAddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public void create(UserAddress address) throws IllegalArgumentException {

        if(address == null){
            throw new IllegalArgumentException("address.null");
        }

        if(address.getUser() == null){
            throw new IllegalArgumentException("user.null");
        }

        if (address.getUser().getAddress() != null) {
            throw new IllegalArgumentException("user.already.has.address");
        }

        addressRepository.save(address);

    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(String id, String userId) throws NotFoundException {
        addressRepository.deleteByUserIdAndId(userId, id);
    }

    @Override
    public void update(UserAddress address) throws IllegalArgumentException {
        if (address == null) {
            throw new IllegalArgumentException("address.null");
        }
        addressRepository.save(address);
    }

    @Override
    public UserAddress getById(String id) throws NotFoundException {
        UserAddress address = addressRepository.findOneById(id);

        if (address == null) {
            throw new NotFoundException("address.not.found", id);
        }
        return address;
    }

    @Override
    public UserAddress getByUserId(String userId) throws NotFoundException {
        UserAddress address = addressRepository.findOneByUserId(userId);

        if (address == null) {
            throw new NotFoundException("user.not.have.address", userId);
        }
        return address;
    }

    @Override
    public UserAddress getByIdAndUserId(String id, String userId) throws NotFoundException {
        UserAddress address = addressRepository.findOneByUserIdAndId(userId, id);

        if (address == null) {
            throw new NotFoundException("user.not.have.the.address", userId, id);
        }
        return address;
    }
}
