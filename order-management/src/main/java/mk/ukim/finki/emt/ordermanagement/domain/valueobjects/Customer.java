package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import mk.ukim.finki.emt.usermanagement.domain.modules.User;

@Getter
public class Customer implements ValueObject {

    private final CustomerId id;

    private final String deliveryEmail;

    private final User user;

    public Customer(){
        this.id = CustomerId.randomId(CustomerId.class);
        this.user = this.getUser();
        this.deliveryEmail = "";
    }


    @JsonCreator
    public Customer(@JsonProperty("customer_id") CustomerId id,
                  @JsonProperty("customer_username") User user,
                  @JsonProperty("deliveryEmail") String deliveryEmail) {
        this.id = id;
        this.user = user;
        this.deliveryEmail = deliveryEmail;
    }

}
