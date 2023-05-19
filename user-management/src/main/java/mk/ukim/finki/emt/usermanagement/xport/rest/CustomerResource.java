package mk.ukim.finki.emt.usermanagement.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.modules.Customer;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.services.CustomerService;
import mk.ukim.finki.emt.usermanagement.services.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/customers")
@AllArgsConstructor
public class CustomerResource {

    private final CustomerService customerService;

    @GetMapping
    public List<Customer>  findAll(){
        return customerService.findAll();
    }
}
