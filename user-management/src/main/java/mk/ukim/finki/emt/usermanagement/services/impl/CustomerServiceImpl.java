package mk.ukim.finki.emt.usermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.usermanagement.domain.modules.Customer;
import mk.ukim.finki.emt.usermanagement.domain.modules.CustomerId;
import mk.ukim.finki.emt.usermanagement.domain.repository.CustomerRepository;
import mk.ukim.finki.emt.usermanagement.services.CustomerService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    @Override
    public Customer findById(CustomerId id) {
        return customerRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
}
