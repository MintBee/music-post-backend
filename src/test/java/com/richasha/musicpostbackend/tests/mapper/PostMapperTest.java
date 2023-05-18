package com.richasha.musicpostbackend.tests.mapper;

import com.richasha.musicpostbackend.dto.CommentDto;
import com.richasha.musicpostbackend.dto.PostDto;
import com.richasha.musicpostbackend.entity.CommentEntity;
import com.richasha.musicpostbackend.entity.MusicEntity;
import com.richasha.musicpostbackend.entity.PostEntity;
import com.richasha.musicpostbackend.entity.UserEntity;
import com.richasha.musicpostbackend.entity.util.GeometryUtil;
import com.richasha.musicpostbackend.mapper.entitydto.PostMapper;
import com.richasha.musicpostbackend.tests.mapper.mock.MockPost;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.locationtech.jts.geom.Point;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostMapperTest {
    private PostEntity testPostEntity;
    private List<CommentEntity> testComments;

    private PostDto testPostDto;
    private List<CommentDto> testCommentDtos;

    @Autowired
    private final PostMapper postMapper = Mappers.getMapper(PostMapper.class);

    @BeforeEach
    public void initEntity() {
        testPostEntity = MockPost.mockPostEntityNotCommentsSet();
        testComments = List.of(
                new CommentEntity(0L, testPostEntity, testPostEntity.getOriginalPoster(), "comment1"),
                new CommentEntity(1L, testPostEntity, testPostEntity.getOriginalPoster(), "comment2"),
                new CommentEntity(2L, testPostEntity, testPostEntity.getOriginalPoster(), "comment3")
        );
        testPostEntity.setComments(testComments);
    }

    @BeforeEach
    public void initDto() {
        testPostDto = MockPost.mockPostDtoNotCommentsSet();
        testCommentDtos = List.of(
                new CommentDto(0L, testPostDto.getId(), testPostDto.getOriginalPoster(), "comment1"),
                new CommentDto(1L, testPostDto.getId(), testPostDto.getOriginalPoster(), "comment2"),
                new CommentDto(2L, testPostDto.getId(), testPostDto.getOriginalPoster(), "comment3")
        );
        testPostDto.setComments(testCommentDtos);
    }

    @AfterEach
    public void reset() {
        testPostEntity = null;
        testComments = null;
    }

    @Test
    public void toDtoTest() {
        System.out.println(postMapper.toDto(testPostEntity));
    }

    @Test
    public void toEntityTest() {
        System.out.println(postMapper.toEntity(testPostDto));}

}
