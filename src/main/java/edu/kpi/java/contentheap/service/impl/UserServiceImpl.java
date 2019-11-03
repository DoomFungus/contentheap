package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.User;
import edu.kpi.java.contentheap.repository.UserRepository;
import edu.kpi.java.contentheap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(String name) {
        userRepository.save(new User(name)).subscribe(System.out::println);
    }

    @Override
    public Flux<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<User> getUser(String name) {
        return userRepository.findByName(name);
    }
}
