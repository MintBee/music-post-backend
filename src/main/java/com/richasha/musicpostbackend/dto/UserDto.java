package com.richasha.musicpostbackend.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.UserEntity} entity
 */
@Data
public class UserDto implements Serializable {
    private final String username;
}