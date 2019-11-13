package edu.kpi.java.contentheap.controller;

import edu.kpi.java.contentheap.message.in.LikeForm;
import edu.kpi.java.contentheap.model.Like;
import edu.kpi.java.contentheap.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;

@RestController
public class LikeController {
    private LikeService likeService;

    @Autowired
    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping(value = "/likes", consumes = "application/json")
    public void saveLike(@RequestBody LikeForm likeForm){
        likeService.saveLike(likeForm.getPostId(), likeForm.getUserId());
    }

    @GetMapping(value = "/likes", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Like> getLikesByPost(@RequestParam String postId){
        return likeService.getLikesByPost(postId);
    }
}
