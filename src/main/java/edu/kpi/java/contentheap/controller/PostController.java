package edu.kpi.java.contentheap.controller;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Optional;

@RestController
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping(value = "/posts", consumes = "application/json")
    public void savePost(@RequestBody Post post){
        postService.savePost(post);
    }

    @GetMapping(value = "/posts", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Post> getPosts(@RequestParam(required = false) List<String> tagNames,
                               @RequestParam(required = false) String author){
        return postService.getPosts(tagNames, author);
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Post> getPost(@PathVariable String id){
        return postService.getPost(id);
    }
}
