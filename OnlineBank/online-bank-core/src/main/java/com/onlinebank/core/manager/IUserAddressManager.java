package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.UserAddress;

public interface IUserAddressManager {

void create(UserAddress address) throws IllegalArgumentException;
}
