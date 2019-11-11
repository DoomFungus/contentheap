package edu.kpi.java.contentheap.controller;

import edu.kpi.java.contentheap.message.PostDTO;
import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.ZonedDateTime;
import java.util.List;


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
    public Flux<PostDTO> getPosts(@RequestParam(required = false) List<String> tagNames,
                                 @RequestParam(required = false) String author,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime afterDate,
                                 @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) ZonedDateTime beforeDate){
        return postService.getPosts(tagNames, author, afterDate, beforeDate);
    }

    @GetMapping(value = "/posts/{id}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<PostDTO> getPost(@PathVariable String id){
        return postService.getPost(id);
    }
}
