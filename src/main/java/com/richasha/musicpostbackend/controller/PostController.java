package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.PostDto;
import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.mapper.entitydto.PostMapper;
import com.richasha.musicpostbackend.repo.PostRepository;
import com.richasha.musicpostbackend.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;
    private final PostMapper postMapper;
    private final PostRepository postRepository;

    @GetMapping
    public List<PostDto> getPosts(
            @RequestParam(value = "page", defaultValue = "0") int page,
            @RequestParam(value = "size", defaultValue = "10") int size
    ) throws Exception {
        return postService.getPaginatedPosts(page, size)
                .stream().map(postMapper::toDto).toList();
    }

    @GetMapping("{postId}/related-posts")
    public List<PostDto> getRelatedPostsById(@PathVariable Long postId) throws Exception {
        return postService.getRelatedPostsById(postId)
                .stream().map(postMapper::toDto).toList();
    }

    @PostMapping
    public PostDto post(@RequestBody PostDto postDto) {
        var thePostEntity = postMapper.toEntity(postDto);
        var savedEntity = postRepository.save(thePostEntity);
        return postMapper.toDto(savedEntity);
    }

    private PostEntity initEntity(PostDto postDto) {
        var newPost = postMapper.toEntity(postDto);
        newPost.setId(null);
        newPost.setLikeCount(0);
        newPost.setComments(new ArrayList<>());
        return newPost;
    }
}
