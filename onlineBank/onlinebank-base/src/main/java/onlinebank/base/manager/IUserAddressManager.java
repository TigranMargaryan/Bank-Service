package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.UserAddress;
import com.onlinebank.core.exeption.NotFoundException;

public interface IUserAddressManager {

void create(UserAddress address) throws IllegalArgumentException;

void delete(String id, String userId) throws NotFoundException;

void update(UserAddress address) throws IllegalArgumentException;

UserAddress getById(String id) throws NotFoundException;

UserAddress getByUserId(String userId) throws NotFoundException;

UserAddress getByIdAndUserId(String id, String userId) throws NotFoundException;
}
