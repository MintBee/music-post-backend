package com.richasha.musicpostbackend.dto;

import com.richasha.musicpostbackend.entity.MusicEntity;
import lombok.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.Set;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.PostEntity} entity
 */
@Data
public class PostDto implements Serializable {
    private final Long id;
    private final UserDto originalPoster;
    private final String title;
    private final String description;
    private final int likeCount;
    private final MusicEntity music;
    private final Point coordinate;
    private final Set<CommentDto> commentEntities;
}