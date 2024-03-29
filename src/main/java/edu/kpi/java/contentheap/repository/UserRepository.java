package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserRepository extends ReactiveMongoRepository<User, String> {
}
