package com.richasha.musicpostbackend.tests.mapper.mock;

import com.richasha.musicpostbackend.dto.PostDto;
import com.richasha.musicpostbackend.entity.PostEntity;

public class MockPost {
    private static final Long ID = 0L;
    private static final String TITLE = "Title for test";
    private static final String DESCRIPTION = "Description for test";
    private static final String ADDRESS = "서울 동작구 흑석로 20";
    private static final String LOCATION_NAME = "이디야";

    public static PostEntity mockPostEntityNotCommentsSet() {
        return PostEntity.builder()
                .id(ID)
                .originalPoster(MockUser.mockEntity())
                .title(TITLE)
                .description(DESCRIPTION)
                .music(MockMusic.mockEntity())
                .address(ADDRESS)
                .location_name(LOCATION_NAME)
                .coordinate(MockPoint.mockEntity())
                .likeCount(0)
                .build();
    }

    public static PostDto mockPostDtoNotCommentsSet() {
        return new PostDto(ID,
                MockUser.mockDto(),
                TITLE,
                DESCRIPTION,
                0,
                MockMusic.mockDto(),
                ADDRESS,
                LOCATION_NAME,
                null,
                MockPoint.mockDto());

    }
}

