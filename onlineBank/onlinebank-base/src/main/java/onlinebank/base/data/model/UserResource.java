package onlinebank.base.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class UserResource {

    private String id;

    @NotNull
    @Length(max = 50)
    private String firstName;

    @NotNull
    @Length(max = 50)
    private String lastName;

    @NotNull
    private String username;

    @NotNull
    private String password;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private CreditCardResource creditCard;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private WaterResource water;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public WaterResource getWater() {
        return water;
    }

    public void setWater(WaterResource water) {
        this.water = water;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public CreditCardResource getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCardResource creditCard) {
        this.creditCard = creditCard;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserResource{");
        sb.append("id=").append(id);
        sb.append(", first_name='").append(firstName).append('\'');
        sb.append(", last_name='").append(lastName).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append(", password='").append(password).append('\'');;
        sb.append('}');
        return sb.toString();
    }
}
