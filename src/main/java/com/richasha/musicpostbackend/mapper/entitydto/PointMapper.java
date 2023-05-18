package com.richasha.musicpostbackend.mapper.entitydto;

import com.richasha.musicpostbackend.dto.PointDto;
import com.richasha.musicpostbackend.entity.util.GeometryUtil;
import org.locationtech.jts.geom.Coordinate;
import org.locationtech.jts.geom.GeometryFactory;
import org.locationtech.jts.geom.Point;
import org.mapstruct.Mapper;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class PointMapper {
    @Autowired
    protected GeometryFactory geometryFactory;

    public PointDto toDto(Point point) {
        if (point != null) {
            return new PointDto(point.getX(), point.getY());
        } else {
            return null;
        }

    }

    public Point toEntity(PointDto pointDto) {
        return geometryFactory.createPoint(new Coordinate(pointDto.getLongitude(),
                pointDto.getLatitude()));
    }
}
