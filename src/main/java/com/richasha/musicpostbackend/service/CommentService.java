package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.CommentEntity;
import lombok.NonNull;

import java.util.List;
import java.util.NoSuchElementException;

public interface CommentService {
    CommentEntity createComment(CommentEntity commentEntity);

    void deleteComment(CommentEntity commentEntity);

    void deleteCommentById(@NonNull Long id);

    CommentEntity getComment(long commentId) throws NoSuchElementException;

    List<CommentEntity> getComments(long postId);
}
