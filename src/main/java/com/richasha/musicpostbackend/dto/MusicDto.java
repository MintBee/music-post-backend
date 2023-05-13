package com.richasha.musicpostbackend.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.MusicEntity} entity
 */
@Data
public class MusicDto implements Serializable {
    private final String genre;
    private final String artist;
    private final String songName;
}