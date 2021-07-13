package geometries;

import primitives.Point3D;
import primitives.Ray;
import java.util.List;
import java.util.stream.Collectors;

/**
 * interface  for Intersects
 */
public interface Intersectable {
    /**
     *class GeoPoint for intersects point with geometry
     */
    public static class GeoPoint{
        public Geometry geometry;
        public Point3D point;

            /**
             *basic constructor
             * @param geometry for this.geometry
             * @param point for this.point
             */
        public GeoPoint(Geometry geometry, Point3D point) {
            this.geometry = geometry;
            this.point = point;
        }

            /**
             * check it 2 geo point are equals
             * @param o another GeoPoint
             * @return true it 2 geo point are equals and false if not
             */
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof GeoPoint)) return false;
            GeoPoint geoPoint = (GeoPoint) o;
            return geometry.equals(geoPoint.geometry) && point.equals(geoPoint.point);
        }

    }


    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object.
     * @return the intersections with the object
     */
    default List<Point3D> findIntersections(Ray ray) {
        var geoList = findGeoIntersections(ray);
        return geoList == null ? null
                : geoList.stream()
                .map(gp -> gp.point)
                .collect(Collectors.toList());
    }

    /**
     * Gives all the points where the given ray is intersecting with the object using infinity distance
     * @param ray A ray to check if is intersecting with the object
     * @return the intersections with the object
     */
    default List<GeoPoint> findGeoIntersections(Ray ray){
        return findGeoIntersections(ray, Double.POSITIVE_INFINITY);
    }

    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object
     * @param maxDistance the max distance
     * @return the intersections with the object
     */
    List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance);
}
