package edu.kpi.java.contentheap.repository;

import edu.kpi.java.contentheap.model.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface LikeRepository extends ReactiveMongoRepository<Like, Like.Key> {
    Flux<Like> findByKeyPostId(String postId);
}
