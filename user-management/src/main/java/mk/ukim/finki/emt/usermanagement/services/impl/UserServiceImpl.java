package mk.ukim.finki.emt.usermanagement.services.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.usermanagement.domain.exceptions.UserNotFoundException;
import mk.ukim.finki.emt.usermanagement.domain.modules.User;
import mk.ukim.finki.emt.usermanagement.domain.modules.UserId;
import mk.ukim.finki.emt.usermanagement.domain.repository.UserRepository;
import mk.ukim.finki.emt.usermanagement.services.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findById(UserId id) {
        return userRepository.findById(id).orElseThrow(UserNotFoundException::new);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
