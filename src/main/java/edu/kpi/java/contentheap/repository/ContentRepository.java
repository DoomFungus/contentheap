package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.Content;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ContentRepository extends ReactiveMongoRepository<Content, String> {
}
