package com.onlinebank.core.data.domain;


import javax.persistence.*;

@Entity
@Table(name = "Branch")
public class Branch extends BaseEntity{

    @Column(name = "name")
    private String name;

    @Column(name = "assets")
    private String assets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAssets() {
        return assets;
    }

    public void setAssets(String assets) {
        this.assets = assets;
    }
}
