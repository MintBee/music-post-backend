package com.richasha.musicpostbackend.tests.mapper.mock;

import com.richasha.musicpostbackend.dto.MusicDto;
import com.richasha.musicpostbackend.entity.MusicEntity;

public class MockMusic {
    public static final Long ID = 0L;
    public static final String GENRE = "Hiphop";
    public static final String ARTIST = "Me";
    public static final String SONG_NAME = "testing houl";
    public static final String MUSIC_URL = "music url";


    public static MusicEntity mockEntity() {
        return new MusicEntity(0L, GENRE, ARTIST, SONG_NAME, MUSIC_URL);
    }

    public static MusicDto mockDto() {
        return new MusicDto(ARTIST, SONG_NAME, MUSIC_URL);
    }
}
