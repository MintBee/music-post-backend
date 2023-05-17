package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.MusicDto;
import com.richasha.musicpostbackend.entity.MusicEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    MusicDto toDto(MusicEntity musicEntity);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "genre", ignore = true)
    MusicEntity toEntity(MusicDto musicDto);

}
