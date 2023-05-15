package com.richasha.musicpostbackend.service;


import com.richasha.musicpostbackend.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.List;

// TODO: 2023-05-16   
@Service
public class PostServiceImpl implements PostService {
    @Override
    public List<PostEntity> getPaginatedPosts(int page, int size) {
        return null;
    }

    @Override
    public PostEntity getPostById(Long postId) {
        return null;
    }

    @Override
    public PostEntity createPost(PostEntity post) {
        return null;
    }

    @Override
    public List<PostEntity> getRelatedPostsById(Long postId) {
        return null;
    }


}
