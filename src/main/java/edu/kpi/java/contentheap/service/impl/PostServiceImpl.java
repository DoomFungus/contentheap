package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.*;
import edu.kpi.java.contentheap.repository.ContentRepository;
import edu.kpi.java.contentheap.repository.PostRepository;
import edu.kpi.java.contentheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository postRepository;
    private ContentRepository contentRepository;

    @Autowired
    public PostServiceImpl(PostRepository postRepository, ContentRepository contentRepository) {
        this.postRepository = postRepository;
        this.contentRepository = contentRepository;
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
}