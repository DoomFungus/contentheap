package edu.kpi.java.contentheap.repository.extensions.impl;

import edu.kpi.java.contentheap.model.Post;
import edu.kpi.java.contentheap.model.Tag;
import edu.kpi.java.contentheap.model.User;
import edu.kpi.java.contentheap.repository.extensions.PostRepositoryExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public class PostRepositoryExtImpl implements PostRepositoryExt {
    private ReactiveMongoTemplate mongoTemplate;

    @Autowired
    public PostRepositoryExtImpl(ReactiveMongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    //TODO: Rework this spaghetti
    @Override
    public Flux<Post> findPosts(List<Tag> tags, User author, LocalDateTime afterDate, LocalDateTime beforeDate) {
        Query query = new Query();
        if(tags != null) query.addCriteria(Criteria.where("tags").all(tags));
        if(author != null) query.addCriteria(Criteria.where("author").is(author));
        if(afterDate != null && beforeDate != null)
            query.addCriteria(
                    new Criteria().andOperator(
                            Criteria.where("creationTimestamp").gte(afterDate),
                            Criteria.where("creationTimestamp").lte(beforeDate)));
            else if(afterDate != null) query.addCriteria(Criteria.where("creationTimestamp").gte(afterDate));
            else if(beforeDate != null)  query.addCriteria(Criteria.where("creationTimestamp").lte(beforeDate));
        return mongoTemplate.find(query, Post.class);
    }
}
