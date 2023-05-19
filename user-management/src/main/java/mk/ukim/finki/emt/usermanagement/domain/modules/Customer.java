package mk.ukim.finki.emt.usermanagement.domain.modules;


import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
@Getter
public class Customer extends AbstractEntity<CustomerId> {

    private String deliveryEmail;

    @OneToOne
    @JoinColumn(name = "user_customer")
    private User user;


    public Customer(){
        super(CustomerId.randomId(CustomerId.class));
    }

    public static Customer build(String deliveryEmail, User user){
        Customer customer = new Customer();
        customer.deliveryEmail = deliveryEmail;
        customer.user = user;
        return customer;
    }
}
