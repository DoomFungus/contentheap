package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.*;
import edu.kpi.java.contentheap.repository.ContentRepository;
import edu.kpi.java.contentheap.repository.PostRepository;
import edu.kpi.java.contentheap.repository.TagRepository;
import edu.kpi.java.contentheap.repository.extensions.PostRepositoryExt;
import edu.kpi.java.contentheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ContentRepository contentRepository;
    private PostRepositoryExt postRepositoryExt;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ContentRepository contentRepository,
                           PostRepositoryExt postRepositoryExt) {
        this.postRepository = postRepository;
        this.contentRepository = contentRepository;
        this.postRepositoryExt = postRepositoryExt;
    }

    @Override
    public void savePost(Post post) {
        contentRepository.save(post.getContent()).subscribe(
                x -> {
                    post.setContent(x);
                    postRepository.save(post).subscribe();
                }
        );
    }

    @Override
    public Flux<Post> getAllPosts() {
        return postRepository.findAll();
    }

    @Override
    public Mono<Post> getPost(String id) {
        return postRepository.findById(id);
    }

    @Override
    public Flux<Post> getPostsByTags(List<String> tags) {
        return postRepositoryExt.findPostsByTags(tags.stream().map(Tag::new).collect(Collectors.toList()));
    }
}