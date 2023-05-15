package com.richasha.musicpostbackend.dto;

import lombok.Data;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.PostEntity} entity
 */
@Data
public class PostDto implements Serializable {
    private final Long id;
    private final UserDto originalPoster;
    private final String title;
    private final String description;
    private final int likeCount = 0;
    private final MusicDto music;
    private final Point coordinate;
    private final String address;
    private final String location_name;
    private final List<CommentDto> comments = new ArrayList<>();
}