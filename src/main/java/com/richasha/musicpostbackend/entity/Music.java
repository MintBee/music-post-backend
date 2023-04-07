package com.richasha.musicpostbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "artist", nullable = false)
    private String artist;

    @Column(name = "song_name", nullable = false)
    private String songName;
}
