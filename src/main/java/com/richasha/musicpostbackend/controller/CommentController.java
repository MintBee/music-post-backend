package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.mapper.entitydto.CommentMapper;
import com.richasha.musicpostbackend.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final CommentMapper commentMapper;
    private final CommentRepository repository;

    @GetMapping("/{postId}")
    public List<CommentDto> getCommentsOfPost(@PathVariable Long postId) throws Exception {
        return repository.findAllByPost_Id(postId).stream().map(commentMapper::toDto).toList();
    }

    @PostMapping("/{postId}")
    public CommentDto postCommentOfPost(@PathVariable Long postId, @RequestBody CommentDto commentDto) throws Exception {
        CommentEntity newComment = initEntity(commentDto);
        return commentMapper.toDto(repository.save(newComment));
    }

    @DeleteMapping("/{postId}/{commentId}")
    public void deleteCommentOfPost(@PathVariable Long postId, @PathVariable Long commentId) throws Exception {
        //todo
    }

    private CommentEntity initEntity(CommentDto commentDto) {
        var newComment = commentMapper.toEntity(commentDto);
        newComment.setId(null);
        return newComment;
    }
}
