package edu.kpi.java.contentheap.repository.extensions.impl;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.repository.extensions.PostRepositoryExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.List;

@Repository
public class PostRepositoryExtImpl implements PostRepositoryExt {
    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public PostRepositoryExtImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Flux<Post> findPostsByTags(List<Tag> tags) {
        return mongoTemplate.find(Query.query(Criteria.where("tags").all(tags)), Post.class);
    }
}
