package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface PostService {
    void savePost(Post post);
    Flux<Post> getAllPosts();
    Mono<Post> getPost(String id);
    Flux<Post> getPostsByTags(List<String> tags);
}
