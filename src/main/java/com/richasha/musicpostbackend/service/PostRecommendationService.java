package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PostEntity;

import java.util.Set;


public interface PostRecommendationService {
    Set<PostEntity> getPosts(int count);
}
