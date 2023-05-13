package com.richasha.musicpostbackend.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.CommentEntity} entity
 */
@Data
public class CommentDto implements Serializable {
    private final Long postId;
    private final UserDto commenter;
    private final String commentText;
}