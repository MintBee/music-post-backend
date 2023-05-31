package com.richasha.musicpostbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.PinEntity} entity
 */
@Data
@NoArgsConstructor
public class PinDto {
    private Long id;
    private UserDto owner;
    private MusicDto music;
    private String address;
    private String locationName;
    private PointDto coordinate;
}