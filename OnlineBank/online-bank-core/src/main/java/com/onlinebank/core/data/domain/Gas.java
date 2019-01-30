package com.onlinebank.core.data.domain;

import javax.persistence.*;

@Entity
@Table(name = "gas")
public class Gas extends BaseEntity{

    @Column(name = "debt")
    private Long debt;

    @Column(name = "date")
    private String date;

    @Column(name = "service")
    private String service;

    public Long getDebt() {
        return debt;
    }

    public void setDebt(Long debt) {
        this.debt = debt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }
}
