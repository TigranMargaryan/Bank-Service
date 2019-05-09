package onlinebank.base.manager;

import onlinebank.base.data.domain.UserAddress;
import onlinebank.base.exeption.NotFoundException;

public interface IUserAddressManager {

void create(UserAddress address) throws IllegalArgumentException;

void delete(String id, String userId) throws NotFoundException;

void update(UserAddress address) throws IllegalArgumentException;

UserAddress getById(String id) throws NotFoundException;

UserAddress getByUserId(String userId) throws NotFoundException;

UserAddress getByIdAndUserId(String id, String userId) throws NotFoundException;
}
