package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.Like;
import edu.kpi.java.contentheap.repository.LikeRepository;
import edu.kpi.java.contentheap.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }


    @Override
    public void saveLike(String postId, String userId) {
        likeRepository.save(new Like(postId, userId)).subscribe();
    }

    @Override
    public Flux<Like> getLikesByPost(String postId) {
        return likeRepository.findByKeyPostId(postId);
    }
}
