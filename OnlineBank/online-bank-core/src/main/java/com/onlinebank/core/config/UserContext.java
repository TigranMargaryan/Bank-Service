package com.onlinebank.core.config;

import java.io.Serializable;

public abstract class UserContext implements Serializable {
    public abstract String getUserID();
}