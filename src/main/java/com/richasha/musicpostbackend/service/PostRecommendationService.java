package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.Post;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public interface PostRecommendationService {
    Set<Post> getPosts(int count);
}
