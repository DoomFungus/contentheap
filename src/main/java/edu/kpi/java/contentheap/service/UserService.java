package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.model.User;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    void saveUser(String name);
    Flux<User> getAllUsers();
    Mono<User> getUser(String name);
}
