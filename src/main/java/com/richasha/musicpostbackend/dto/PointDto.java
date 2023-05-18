package com.richasha.musicpostbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

// TODO: 2023-05-17 Add manual model mapper between this and `Point`
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PointDto implements Serializable {
    private Double longitude;
    private Double latitude;
}
