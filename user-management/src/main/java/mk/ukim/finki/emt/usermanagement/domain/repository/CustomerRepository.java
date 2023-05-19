package mk.ukim.finki.emt.usermanagement.domain.repository;

import mk.ukim.finki.emt.usermanagement.domain.modules.Customer;
import mk.ukim.finki.emt.usermanagement.domain.modules.CustomerId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, CustomerId> {
}
