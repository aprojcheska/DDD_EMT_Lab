package mk.ukim.finki.emt.usermanagement.services;

import mk.ukim.finki.emt.usermanagement.domain.modules.Customer;
import mk.ukim.finki.emt.usermanagement.domain.modules.CustomerId;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.domain.modules.UserId;

import java.util.List;

public interface CustomerService {
    Customer findById(CustomerId id);
    List<Customer> findAll();
}
