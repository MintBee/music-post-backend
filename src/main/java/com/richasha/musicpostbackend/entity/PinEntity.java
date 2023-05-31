package com.richasha.musicpostbackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.locationtech.jts.geom.Point;

@Entity
@Table(name = "pin", schema = "public")
@Getter
@Setter
public class PinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, optional = false, orphanRemoval = true)
    @JoinColumn(name = "owner_id", nullable = false)
    private UserEntity owner;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, orphanRemoval = true)
    @JoinColumn(name = "music_id")
    private MusicEntity music;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "coordinate", nullable = false)
    private Point coordinate;


}
