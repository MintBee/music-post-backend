package com.richasha.musicpostbackend.tests.mapper.mock;

import com.richasha.musicpostbackend.dto.PointDto;
import com.richasha.musicpostbackend.entity.util.GeometryUtil;
import org.locationtech.jts.geom.Point;

public class MockPoint {
    private static final double LONGITUDE = 126.9530;
    private static final double LATITUDE = 37.5048;

    public static Point mockEntity() {
        return GeometryUtil.parseLocation(LONGITUDE, LATITUDE);
    }

    public static PointDto mockDto() {
        return new PointDto(LONGITUDE, LATITUDE);
    }
}