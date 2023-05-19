package mk.ukim.finki.emt.usermanagement.config;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.modules.Artist;
import mk.ukim.finki.emt.usermanagement.domain.modules.Customer;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.domain.repository.ArtistRepository;
import mk.ukim.finki.emt.usermanagement.domain.repository.CustomerRepository;
import mk.ukim.finki.emt.usermanagement.domain.repository.UserRepository;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;


@Component
@AllArgsConstructor
public class UsersInitializer {
    private final UserRepository userRepository;
    private final ArtistRepository artistRepository;
    private final CustomerRepository customerRepository;

    @PostConstruct
    public void initData() {
        User u1 = User.build("artist1", "a1");
        User u2 = User.build("artist2", "a2");
        User u3 = User.build("customer1", "c1");
        User u4 = User.build("customer2", "c2");

        if (userRepository.findAll().isEmpty()) {
            userRepository.saveAll(Arrays.asList(u1, u2, u3, u4));
        }
        Customer customer1 = Customer.build("costumer1@mail", u3);
        Customer customer2 = Customer.build("costumer2@mail", u4);
        if (customerRepository.findAll().isEmpty()) {
            customerRepository.saveAll(Arrays.asList(customer1, customer2));
        }

        Artist artist1 = Artist.build("Biography for artist1", u1);
        Artist artist2 = Artist.build("Biography for artist2", u2);
        if (artistRepository.findAll().isEmpty()) {
            artistRepository.saveAll(Arrays.asList(artist1, artist2));
        }
    }
}
