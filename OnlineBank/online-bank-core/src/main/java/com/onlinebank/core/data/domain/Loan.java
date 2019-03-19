package com.onlinebank.core.data.domain;

import javax.persistence.*;

@Entity
@Table(name = "loan")
public class Loan extends BaseEntity{

    @Column(name = "amount")
    private Long amount;

    @OneToOne(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "branch_id", nullable = false)
    private Branch branch;

    public String getUserID() {
        if (getUser() != null) {
            return getUser().getId();
        }

        return null;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }
}
