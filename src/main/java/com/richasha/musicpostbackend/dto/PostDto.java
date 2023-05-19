package com.richasha.musicpostbackend.dto;

import lombok.Data;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.PostEntity} entity
 */
@Data
@NoArgsConstructor
public class PostDto implements Serializable {
    private Long id;
    private UserDto originalPoster;
    private String title;
    private String description;
    private int likeCount = 0;
    private MusicDto music;
    private String address;
    private String locationName;
    private List<CommentDto> comments = new ArrayList<>();
    private PointDto coordinate;
}