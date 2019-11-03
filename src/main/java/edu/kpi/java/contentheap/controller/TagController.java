package edu.kpi.java.contentheap.controller;

import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class TagController {
    private TagService tagService;

    @Autowired
    public TagController(TagService tagService) {
        this.tagService = tagService;
    }

    @PostMapping("/tags")
    public void saveTag(@RequestBody String name){
        tagService.saveTag(name);
    }

    @GetMapping(value = "/tags", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tag> getAllTags(){
        return tagService.getAllTags();
    }

    @GetMapping(value = "/tags/{name}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Mono<Tag> getTag(@PathVariable String name){
        return tagService.getTag(name);
    }
}
