package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.PostDto;
import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final ModelMapper modelMapper;

    @GetMapping
    public List<PostDto> getPosts(
            @RequestParam("page") int page,
            @RequestParam("size") int size
    ) {
        return postService.getPaginatedPosts(page, size)
                .stream().map(this::convertToDto).toList();
    }

    @GetMapping("{postId}/related-posts")
    public List<PostDto> getRelatedPostsById(@PathVariable Long postId) {
        return postService.getRelatedPostsById(postId)
                .stream().map(this::convertToDto).toList();
    }

    @PostMapping()
    public PostDto createPost(@RequestBody PostDto post) {
        return convertToDto(postService.createPost(initEntity(post)));
    }

    private PostDto convertToDto(PostEntity postEntity) {
        return modelMapper.map(postEntity, PostDto.class);
    }

    private PostEntity initEntity(PostDto postDto) {
        var newPost = convertToEntity(postDto);
        newPost.setId(null);
        newPost.setLikeCount(0);
        newPost.setComments(new ArrayList<>());
        return newPost;
    }

    private PostEntity convertToEntity(PostDto postDto) {
        return modelMapper.map(postDto, PostEntity.class);
    }

}
