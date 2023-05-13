package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.Post;

import java.util.Set;


public interface PostRecommendationService {
    Set<Post> getPosts(int count);
}
