package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.MusicDto;
import com.richasha.musicpostbackend.entity.MusicEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MusicMapper {
    MusicDto toDto(MusicEntity musicEntity);
    MusicEntity toEntity(MusicDto musicDto);

}
