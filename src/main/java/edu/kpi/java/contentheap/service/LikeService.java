package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.model.Like;
import reactor.core.publisher.Flux;

public interface LikeService {
    void saveLike(String postId, String userId);
    Flux<Like> getLikesByPost(String postId);
}
