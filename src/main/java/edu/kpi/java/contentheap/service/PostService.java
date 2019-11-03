package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.model.Post;
import reactor.core.publisher.Flux;

public interface PostService {
    void savePost(Post post);
    Flux<Post> getAllPosts();
}
