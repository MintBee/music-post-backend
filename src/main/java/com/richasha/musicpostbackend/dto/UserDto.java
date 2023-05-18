package com.richasha.musicpostbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * A DTO for the {@link com.richasha.musicpostbackend.entity.UserEntity} entity
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto implements Serializable {
    private String username;
}