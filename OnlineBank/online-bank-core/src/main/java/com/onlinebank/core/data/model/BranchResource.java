package com.onlinebank.core.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BranchResource {

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String name;

    private String assets;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
public String toString(){
        final StringBuffer buffer = new StringBuffer("BranchResource{");
        buffer.append("id=").append(id);
        buffer.append(", name='").append(name).append('\'');
        buffer.append(", assets='").append(assets).append('\'');
        buffer.append('}');
        return buffer.toString();
    }
}
