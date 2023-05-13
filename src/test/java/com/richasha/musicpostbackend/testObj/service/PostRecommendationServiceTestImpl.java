package com.richasha.musicpostbackend.testObj.service;

import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.service.PostRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("test")
public class PostRecommendationServiceTestImpl implements PostRecommendationService {
    private final Set<PostEntity> mockPosts;

    @Autowired
    public PostRecommendationServiceTestImpl(Set<PostEntity> mockPosts) {
        this.mockPosts = mockPosts;
    }

    @Override
    public Set<PostEntity> getPosts(int count) {
        return new HashSet<>(mockPosts);
    }
}
