package com.onlinebank.core.data.domain;

import javax.persistence.*;

@Entity
@Table(name = "credit_card")
public class CreditCard extends BaseEntity{

    @Column(name = "balance")
    private String balance;

    @Column(name = "type")
    private String type;

    @Column(name = "code")
    private String code;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false, unique = true)
    private User user;

    public String getUserID(){
        if(getUser() != null){
            return getUser().getId();
        }
        return null;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
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
}
