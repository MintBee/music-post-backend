package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
@RequiredArgsConstructor
public abstract class CommentMapper {
    @Autowired
    protected final PostRepository postRepository;

    @Mapping(target = "postId", source = "post.id")
    public abstract CommentDto toDto(CommentEntity commentEntity);
    @Mapping(target = "post", ignore = true)
    public abstract CommentEntity toEntity(CommentDto commentDto);
    @BeforeMapping
    public void beforeToEntity(@MappingTarget CommentEntity commentEntity) {

    }
}

