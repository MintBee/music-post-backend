package com.richasha.musicpostbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.MusicEntity} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MusicDto implements Serializable {
    private String artist;
    private String songName;
    private String music_url;
}