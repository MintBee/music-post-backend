package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.PinDto;
import com.richasha.musicpostbackend.entity.PinEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {PointMapper.class, UserMapper.class, MusicMapper.class
        , CommentMapper.class})
public interface PinMapper {
    PinDto toDto(PinEntity pinEntity);

    PinEntity toEntity(PinDto pinDto);
}
