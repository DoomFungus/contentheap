package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveMongoRepository<Post, String> {
    Flux<Post> findByAuthor(User author);
}
