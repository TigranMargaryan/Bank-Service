package onlinebank.base.data.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.IOException;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreditCardResource {


    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String id;

    private String balance;

    private String type;

    private String code;

    private String phone;

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

    public void setBalance(String balance) throws IOException {


        this.balance = balance;
    }

    public String getUserId() {
                return userId;
            }

            public void setUserId(String userId) {
                this.userId = userId;
            }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

}
