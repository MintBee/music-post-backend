package com.richasha.musicpostbackend.controller;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.repo.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/comments")
public class CommentController {
    private final ModelMapper modelMapper;
    private final CommentRepository repository;

    @GetMapping("/{postId}")
    public List<CommentDto> getCommentsOfPost(@PathVariable Long postId) throws Exception {
        return repository.findAllByPost_Id(postId)
                .stream().map(this::convertToDto)
                .toList();
    }

    @PostMapping("/{postId}")
    public CommentDto postCommentOfPost(@RequestBody CommentDto commentDto) throws Exception {
        CommentEntity newComment = initEntity(commentDto);
        return convertToDto(repository.save(newComment));
    }

    @DeleteMapping("/{postId}/{commentId}")
    public void deleteCommentOfPost(@PathVariable Long postId, @PathVariable Long commentId) throws Exception {
        //todo
    }

    private CommentDto convertToDto(CommentEntity commentEntity) {
        return modelMapper.map(commentEntity, CommentDto.class);
    }

    private CommentEntity initEntity(CommentDto commentDto) {
        var newComment = convertToEntity(commentDto);
        newComment.setId(null);
        return newComment;
    }

    private CommentEntity convertToEntity(CommentDto commentDto) {
        return modelMapper.map(commentDto, CommentEntity.class);
    }


}
