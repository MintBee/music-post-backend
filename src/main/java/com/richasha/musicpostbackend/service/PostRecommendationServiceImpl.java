package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.PostEntity;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PostRecommendationServiceImpl implements PostRecommendationService{

    @Override
    public Set<PostEntity> getPosts(int count) {
        return null;
    }
}
