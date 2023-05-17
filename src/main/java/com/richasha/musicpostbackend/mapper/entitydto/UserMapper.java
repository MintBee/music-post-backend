package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.UserDto;
import com.richasha.musicpostbackend.dto.UserRegistrationDto;
import com.richasha.musicpostbackend.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    @Mapping(target = "username", source = "username")
    UserDto toDto(UserEntity userEntity);

    @Mapping(target = "id", ignore = true)
    UserEntity toEntity(UserRegistrationDto registrationDto);
}
