package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.mapper.entitydto.CommentMapper;
import com.richasha.musicpostbackend.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comment")
public class CommentController {
    private final CommentMapper commentMapper;
    private final CommentService commentService;

    @GetMapping
    public List<CommentDto> getCommentsOfPost(@RequestParam Long postId) throws Exception {
        return commentService.getComments(postId).stream().map(commentMapper::toDto).toList();
    }

    @PostMapping
    public CommentDto postCommentOfPost(@RequestBody CommentDto commentDto) throws Exception {
        CommentEntity newComment = initEntity(commentDto);
    return commentMapper.toDto(commentService.createComment(newComment));
    }

    @DeleteMapping("{commentId}")
    public void deleteCommentOfPost(@PathVariable Long commentId) throws Exception {
        commentService.deleteCommentById(commentId);
    }

    private CommentEntity initEntity(CommentDto commentDto) {
        var newComment = commentMapper.toEntity(commentDto);
        newComment.setId(null);
        return newComment;
    }
}
