package com.richasha.musicpostbackend.service;


import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.repo.PostRepository;
import com.richasha.musicpostbackend.repo.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.locationtech.jts.geom.Point;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    // metric: meters
    public static final int SEARCHING_RADIUS = 50;

    private final PostRepository postRepository;
    private final UserRepository userRepository;

    @Override
    public List<PostEntity> getPaginatedPosts(int page, int size) throws Exception {
        return postRepository.findByOrderByLikeCountDesc(PageRequest.of(page, size));
    }

    @Override
    public List<PostEntity> getPaginatedPostsByDistance(int page, int size,
                                                        Point currentCoordinate, double distance) {
        Pageable pageable = PageRequest.of(page, size);
        return postRepository.findAllNearby(currentCoordinate.getX(), currentCoordinate.getY(),
                distance, pageable);
    }

    @Override
    public PostEntity getPostById(Long postId) throws Exception {
        return postRepository.findById(postId).orElseThrow();
    }

    @Override
    public PostEntity createPost(PostEntity post) {
        post.setOriginalPoster(userRepository.findByUsername(post.getOriginalPoster().getUsername()));
        return postRepository.save(post);
    }

    @Override
    public List<PostEntity> getRelatedPostsById(Long postId) throws Exception {
        List<PostEntity> results = new ArrayList<>();
        if (postRepository.existsById(postId)) {
            var thePost = postRepository.findById(postId).orElseThrow();
            var postCoordinate = thePost.getCoordinate();
            var nearbyPosts = postRepository.findAllNearby(postCoordinate.getX(),
                    postCoordinate.getY(), SEARCHING_RADIUS);
            results.addAll(nearbyPosts);
            return results;
        } else throw new EntityNotFoundException("No such post exists.");
    }


}
