package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
    public Mono<User> findByName(String name);
}
