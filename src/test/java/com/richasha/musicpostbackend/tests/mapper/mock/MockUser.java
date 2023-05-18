package com.richasha.musicpostbackend.tests.mapper.mock;

import com.richasha.musicpostbackend.dto.UserDto;
import com.richasha.musicpostbackend.entity.UserEntity;

public class MockUser {
    private static final String USERNAME = "test";
    private static final String PASSWORD = "testpswd";


    public static UserEntity mockEntity() {
        return new UserEntity(USERNAME, PASSWORD);
    }

    public static UserDto mockDto() {
        return new UserDto(USERNAME);
    }
}
