package edu.kpi.java.contentheap.repository.extensions;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import reactor.core.publisher.Flux;

import java.util.List;

public interface PostRepositoryExt {
    Flux<Post> findPostsByTags(List<Tag> tags);
}
