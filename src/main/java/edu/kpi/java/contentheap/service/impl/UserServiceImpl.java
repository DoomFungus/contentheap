package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.message.out.UserDTO;
import edu.kpi.java.contentheap.model.User;
import edu.kpi.java.contentheap.repository.UserRepository;
import edu.kpi.java.contentheap.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(String name) {
        userRepository.save(new User(name, LocalDateTime.now())).subscribe();
    }

    @Override
    public Flux<UserDTO> getAllUsers() {
        return userRepository.findAll().map(UserDTO::from);
    }

    @Override
    public Mono<UserDTO> getUser(String name) {
        return userRepository.findById(name).map(UserDTO::from);
    }
}
