package com.onlinebank.core.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class WaterResource {

    private String id;

    private Long debt;

    private String date;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    @Override
    public String toString(){
        final StringBuffer buffer = new StringBuffer("WaterResource{");
        buffer.append("id=").append(id);
        buffer.append(", debt='").append(debt).append('\'');
        buffer.append(", date='").append(date).append('\'');
        buffer.append('}');
        return buffer.toString();
    }
}
