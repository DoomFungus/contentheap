package edu.kpi.java.contentheap.repository.extensions;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.model.User;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PostRepositoryExt {
    Flux<Post> findPosts(List<Tag> tags, User author);
}
