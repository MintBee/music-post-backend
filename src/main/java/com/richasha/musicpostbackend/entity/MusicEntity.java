package com.richasha.musicpostbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "music", schema = "public")
@Getter
@Setter
public class MusicEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "genre", length = 64)
    private String genre;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "song_name", nullable = false)
    private String songName;

    @Column(name = "music_url", nullable = false)
    private String music_url;
}
