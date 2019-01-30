package com.onlinebank.core.manager.imc;

import com.onlinebank.core.data.domain.UserAddress;
import com.onlinebank.core.manager.IUserAddressManager;
import com.onlinebank.core.repository.UserAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
