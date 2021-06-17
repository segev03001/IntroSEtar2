package primitives;

import static geometries.Intersectable.GeoPoint;

import java.util.List;
import java.util.Objects;

public class Ray {
    final Point3D p0;
    final Vector dir;

    public Ray(Point3D p0, Vector dir) {
        this.dir = dir.normalized();
        this.p0 = new Point3D(p0.x,p0.y, p0.z);
    }

    public Point3D getP0() {
        return p0;
    }

    public Vector getDir() {
        return dir;
    }

    public Point3D getPoint(double t)
    {
        return p0.add(dir.scale(t));
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }
}
