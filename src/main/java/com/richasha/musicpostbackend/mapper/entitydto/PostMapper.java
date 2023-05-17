package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.PostDto;
import com.richasha.musicpostbackend.entity.PostEntity;
import org.mapstruct.Mapper;

// TODO: 2023-05-17 Make it mapping Point with PointMapper 
@Mapper(componentModel = "spring", uses = {PointMapper.class, UserMapper.class, MusicMapper.class
        , CommentMapper.class})
public interface PostMapper {
    PostDto toDto(PostEntity postEntity);

    PostEntity toEntity(PostDto postDto);
}
