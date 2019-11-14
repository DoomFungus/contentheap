package edu.kpi.java.contentheap.service.impl;

import edu.kpi.java.contentheap.model.Like;
import edu.kpi.java.contentheap.repository.LikeRepository;
import edu.kpi.java.contentheap.repository.PostRepository;
import edu.kpi.java.contentheap.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class LikeServiceImpl implements LikeService {
    private LikeRepository likeRepository;
    private PostRepository postRepository;

    @Autowired
    public LikeServiceImpl(LikeRepository likeRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.postRepository = postRepository;
    }


    @Override
    public void saveLike(String postId, String userId) {
        likeRepository.save(new Like(postId, userId))
                .subscribe(x -> likeRepository.countByKeyPostId(x.getKey().getPostId()).subscribe(
                        y -> postRepository.findById(x.getKey().getPostId()).subscribe(
                                z -> {
                                    z.setRating(y);
                                    postRepository.save(z).subscribe();
                                }
                        )
                ));
    }

    @Override
    public Flux<Like> getLikesByPost(String postId) {
        return likeRepository.findByKeyPostId(postId);
    }
}
