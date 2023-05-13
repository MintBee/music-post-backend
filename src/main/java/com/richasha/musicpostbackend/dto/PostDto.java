package com.richasha.musicpostbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PostDto {
    private String title;
    private String content;
    private String genre;
    private String artist;
    private String song;
    private String originalPoster;
    private int likeCount;
    private List<CommentDto> commentDtos;
}
