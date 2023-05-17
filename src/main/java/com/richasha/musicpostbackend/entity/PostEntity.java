package com.richasha.musicpostbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "post", schema = "public")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, orphanRemoval = true)
    @JoinColumn(name = "original_poster_id", nullable = false)
    private UserEntity originalPoster;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", length = 1023)
    private String description;

    @Column(name = "like_count", nullable = false, columnDefinition = "integer default 0")
    private int likeCount;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "music_id")
    private MusicEntity music;

    @Column(name = "coordinate", columnDefinition = "geometry(Point, 4326)")
    private Point coordinate;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "location_name")
    private String location_name;

    @OneToMany(mappedBy = "post", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<CommentEntity> comments = new ArrayList<>();
}
