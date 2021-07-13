package primitives;

import static geometries.Intersectable.GeoPoint;

import java.util.List;
import java.util.Objects;

/**
 * basic geometric object for Ray
 */
public class Ray {
    final Point3D p0;
    final Vector dir;

    /**
     * Basic constructor
     * @param p0 Point3D
     * @param dir Vector
     */
    public Ray(Point3D p0, Vector dir) {
        this.dir = dir.normalized();
        this.p0 = new Point3D(p0.x,p0.y, p0.z);
    }

    /**
     * constructor for Ray with light and DELTA
     * @param point Point3D
     * @param lightDirection Vector
     * @param n Vector
     * @param DELTA double
     */
    public Ray(Point3D point, Vector lightDirection, Vector n, double DELTA) {
        Vector delta = n.scale(n.dotProduct(lightDirection) > 0 ? DELTA : - DELTA);
        this.p0 = point.add(delta);
        this.dir = lightDirection.normalized();
    }

    /**
     * get point
     * @return p0 Point3D
     */
    public Point3D getP0() {
        return p0;
    }


    /**
     * get vector
     * @return dir vector
     */
    public Vector getDir() {
        return dir;
    }

    /**
     * calculate the ray with the double
     * @param t number double
     * @return Point3D of the ray with the double
     */
    public Point3D getPoint(double t)
    {
        return p0.add(dir.scale(t));
    }

    /**
     * get lists of point and find the point that closet to the start of the ray
     * @param points list of points
     * @return the point that closet to the start of the ray
     */
    public Point3D getClosestPoint(List<Point3D> points){
        Point3D minPoint = null;
        if (points !=null) {
            double distance = Double.POSITIVE_INFINITY;
            for (Point3D p : points) {
                double temp = p.distance(p0);
                if (temp < distance) {
                    distance = temp;
                    minPoint = p;
                }
            }
        }
        return minPoint;
    }

    /**
     * get lists of GeoPoint and find the point that closet to the start of the ray
     * @param geoPoints list of GeoPoint
     * @return the GeoPoint that closet to the start of the ray
     */
    public GeoPoint getClosestGeoPoint(List<GeoPoint> geoPoints){
        GeoPoint minPoint = null;
        if (geoPoints !=null) {
            double distance = Double.POSITIVE_INFINITY;

            for (GeoPoint geo : geoPoints) {
                double temp = geo.point.distance(p0);
                if (temp < distance) {
                    distance = temp;
                    minPoint = geo;
                }
            }
        }
        return minPoint;
    }

    /**
     * Check when the Rays are equal
     * @param o Another point
     * @return false if they are different and true if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    /**
     * hash function
     * @return the hash number
     */
    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }
}
