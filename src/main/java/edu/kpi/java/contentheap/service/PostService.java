package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.message.out.PostDTO;
import edu.kpi.java.contentheap.model.Post;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.List;

public interface PostService {
    void savePost(Post post);
    Flux<PostDTO> getPosts(List<String> tags, String author, ZonedDateTime afterDate, ZonedDateTime beforeDate);
    Mono<PostDTO> getPost(String id);
}
