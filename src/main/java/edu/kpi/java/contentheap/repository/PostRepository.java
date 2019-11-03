package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.model.User;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface PostRepository extends ReactiveMongoRepository<Post, Integer> {
    @Query("{ tags: { $all: ?0 } }")
    Flux<Post> findByTags(Iterable<Tag> tags);
    @Query("{ author: ?0 }")
    Flux<Post> findByAuthor(User author);
}
