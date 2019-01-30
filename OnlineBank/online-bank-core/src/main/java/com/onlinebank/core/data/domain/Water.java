package com.onlinebank.core.data.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "water")
public class Water extends BaseEntity{

    @Column(name = "debt")
    private Long debt;

    @Column(name = "date")
    private String date;

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
}
