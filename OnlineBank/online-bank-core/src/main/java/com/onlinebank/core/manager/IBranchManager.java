package com.onlinebank.core.manager;

import com.onlinebank.core.data.domain.Branch;
import com.onlinebank.core.data.domain.Gas;

public interface IBranchManager {

    void create(Branch branch) throws IllegalArgumentException;
}
