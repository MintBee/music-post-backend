package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.service.PostRecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostRecommendationService postService;


    @Autowired
    public PostController(PostRecommendationService postService) {
        this.postService = postService;
    }

    @GetMapping
    public List<PostEntity> getPostsByRecommendation(
            @RequestParam(value = "count", defaultValue = "10", required = false)
            Integer postCount
    ) {
        return postService.getPosts(postCount);
    }
}
