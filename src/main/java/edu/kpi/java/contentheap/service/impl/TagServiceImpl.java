package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.repository.TagRepository;
import edu.kpi.java.contentheap.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TagServiceImpl implements TagService {
    private TagRepository tagRepository;

    @Autowired
    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public void saveTag(String name) {
        tagRepository.save(new Tag(name)).subscribe();
    }

    @Override
    public Flux<Tag> getAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Mono<Tag> getTag(String name) {
        return tagRepository.findById(name);
    }
}
