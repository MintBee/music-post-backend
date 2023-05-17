package com.richasha.musicpostbackend.service;


import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.repo.PostRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService {
    // metric: meters
    public static final int SEARCHING_RADIUS = 50;

    private final PostRepository repository;

    @Override
    public List<PostEntity> getPaginatedPosts(int page, int size) throws Exception {
        return repository.findByOrderByLikeCountDesc(PageRequest.of(page, size));
    }

    @Override
    public PostEntity getPostById(Long postId) throws Exception {
        return repository.findById(postId).orElseThrow();
    }

    @Override
    public PostEntity createPost(PostEntity post) {
        return repository.save(post);
    }

    @Override
    public List<PostEntity> getRelatedPostsById(Long postId) throws Exception {
        List<PostEntity> results = new ArrayList<>();
        if (repository.existsById(postId)) {
            var thePost = repository.findById(postId).orElseThrow();
            var postCoordinate = thePost.getCoordinate();
            var nearbyPosts = repository.findAllNearby(postCoordinate.getX(),
                    postCoordinate.getY(), SEARCHING_RADIUS);
            results.addAll(nearbyPosts);
            return results;
        } else throw new EntityNotFoundException("No such post exists.");
    }


}
