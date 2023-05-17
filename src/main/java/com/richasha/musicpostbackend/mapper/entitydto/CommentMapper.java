package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.mapper.context.CycleAvoidingMappingContext;
import com.richasha.musicpostbackend.repo.PostRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

@Mapper(componentModel = "spring", uses = {UserMapper.class})
@RequiredArgsConstructor
public abstract class CommentMapper {
    private PostRepository postRepository;

    @Autowired
    public void setPostRepository(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public abstract List<CommentDto> toDtos(List<CommentEntity> commentEntities);
    public abstract List<CommentEntity> toEntities(List<CommentDto> commentDtos);

    @Mapping(target = "postId", source = "post.id")
    public abstract CommentDto toDto(CommentEntity commentEntity,
                                     @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    public CommentDto toDto(CommentEntity commentEntity) {
        return toDto(commentEntity, new CycleAvoidingMappingContext());
    }

    @Mapping(target = "post", ignore = true)
    public abstract CommentEntity toEntity(CommentDto commentDto, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    public CommentEntity toEntity(CommentDto commentDto) {
        return toEntity(commentDto, new CycleAvoidingMappingContext());
    }

    @BeforeMapping
    public void beforeToEntity(@MappingTarget CommentEntity commentEntity, CommentDto commentDto) {
        Optional<PostEntity> thePost = postRepository.findById(commentDto.getPostId());
        thePost.ifPresent(commentEntity::setPost);
    }
}

