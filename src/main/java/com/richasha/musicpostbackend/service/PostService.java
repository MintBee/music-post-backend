package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PostEntity;

import java.util.List;


public interface PostService {
    List<PostEntity> getPaginatedPosts(int page, int size) throws Exception;
    PostEntity getPostById(Long postId) throws Exception;

    PostEntity createPost(PostEntity post) throws Exception;

    List<PostEntity> getRelatedPostsById(Long postId) throws Exception;
}
