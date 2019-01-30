package com.onlinebank.core.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardResource {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String balance;

    private String type;

    private String code;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("CreditCardResource{");
        sb.append("id=").append(id);
        sb.append(", type='").append(type).append('\'');
        sb.append(", code='").append(code).append('\'');
        sb.append(", balance='").append(balance).append('\'');
        sb.append(", userId=").append(userId);
        sb.append('}');
        return sb.toString();
    }
}
