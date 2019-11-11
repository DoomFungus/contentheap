package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.message.PostDTO;
import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.model.User;
import edu.kpi.java.contentheap.repository.ContentRepository;
import edu.kpi.java.contentheap.repository.PostRepository;
import edu.kpi.java.contentheap.repository.extensions.PostRepositoryExt;
import edu.kpi.java.contentheap.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
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
        post.setCreationTimestamp(LocalDateTime.now());
        contentRepository.save(post.getContent()).subscribe(
                x -> {
                    post.setContent(x);
                    postRepository.save(post).subscribe();
                }
        );
    }

    @Override
    public Flux<PostDTO> getPosts(List<String> tags, String author, ZonedDateTime afterDate, ZonedDateTime beforeDate) {
        List<Tag> oTags = tags == null ? List.of() : tags.stream().map(Tag::new).collect(Collectors.toList());
        User oAuthor = author == null ? null : new User(author);
        LocalDateTime oAfterDate = afterDate == null ? null : afterDate.toLocalDateTime();
        LocalDateTime oBeforeDate = beforeDate == null ? null : beforeDate.toLocalDateTime();
        return postRepositoryExt.findPosts(oTags, oAuthor, oAfterDate, oBeforeDate).map(PostDTO::from);
    }

    @Override
    public Mono<PostDTO> getPost(String id) {
        return postRepository.findById(id).map(PostDTO::from);
    }


}