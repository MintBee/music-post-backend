package com.richasha.musicpostbackend.entity.util;

import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Point;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.WKTReader;

public class GeometryUtil {

    public static final int SRID = 4326; //LatLng
    private static final WKTReader wktReader = new WKTReader();

    private static Geometry wktToGeometry(String wellKnownText) {
        org.locationtech.jts.geom.Geometry geometry = null;

        try {
            geometry = wktReader.read(wellKnownText);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("###geometry :"+geometry);
        return geometry;
    }
    public static Point parseLocation(double longitude, double latitude) {
        Geometry geometry = GeometryUtil.wktToGeometry(String.format("POINT (%s %s)",longitude,
                latitude));
        Point p =(Point)geometry;
        p.setSRID(SRID);
        return p;
    }
}
