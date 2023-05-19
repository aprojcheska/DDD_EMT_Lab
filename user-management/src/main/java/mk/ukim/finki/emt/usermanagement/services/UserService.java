package mk.ukim.finki.emt.usermanagement.services;

import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.domain.modules.UserId;

import java.util.List;

public interface UserService {
    User findById(UserId id);
    List<User> findAll();
}
