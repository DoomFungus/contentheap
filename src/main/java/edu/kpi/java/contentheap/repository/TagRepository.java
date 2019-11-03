package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.Tag;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface TagRepository extends ReactiveMongoRepository<Tag, String> {
}
