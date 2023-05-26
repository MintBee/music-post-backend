package com.richasha.musicpostbackend.service;

import com.richasha.musicpostbackend.entity.CommentEntity;

import java.util.List;

public interface CommentService {
    List<CommentEntity> fetchComments(Long postId);
}
