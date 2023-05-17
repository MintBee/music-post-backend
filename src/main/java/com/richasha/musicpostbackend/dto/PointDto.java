package com.richasha.musicpostbackend.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// TODO: 2023-05-17 Add manual model mapper between this and `Point`
@Data
public class PointDto implements Serializable {
    private final Double longitude;
    private final Double latitude;
}
