package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PostEntity;

import java.util.List;


public interface PostRecommendationService {
    List<PostEntity> getPosts(int count);
}
