package com.richasha.musicpostbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.CommentEntity} entity
 */
@Data
@NoArgsConstructor
public class CommentDto implements Serializable {
    private Long id;
    private Long postId;
    private UserDto commenter;
    private String commentText;
}