package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.message.UserDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {
    void saveUser(String name);
    Flux<UserDTO> getAllUsers();
    Mono<UserDTO> getUser(String name);
}
