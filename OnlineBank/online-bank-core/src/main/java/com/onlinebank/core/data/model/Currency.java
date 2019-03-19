package com.onlinebank.core.data.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import org.json.simple.JSONObject;

import javax.validation.constraints.NotNull;

public enum Currency {

    AMD(1, "amd"),
    RUB(2, "rub"),
    USD(3, "usd");

    @NotNull
    private final Integer value;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String label;

    Currency(int value, String label) {
        this.value = value;
        this.label = label;
    }

    @JsonValue
    public Integer getValue() {
        return value;
    }

    public String getLabel() {
        return label;
    }

    public JSONObject toJSON() {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("value", value);
        jsonObject.put("label", label);
        return jsonObject;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Currency{");
        sb.append("value=").append(value);
        sb.append(", label='").append(label).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
