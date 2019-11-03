package edu.kpi.java.contentheap.service;

import edu.kpi.java.contentheap.model.Tag;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface TagService {
    void saveTag(String name);
    Flux<Tag> getAllTags();
    Mono<Tag> getTag(String name);
}
