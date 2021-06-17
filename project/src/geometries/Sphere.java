package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * basic geometric object for Sphere
 */
public class Sphere extends Geometry {

    protected final Point3D center;
    protected final double radius;

    /**
     * @param center Point3D
     * @param radius double
     */
    public Sphere(double radius, Point3D center) {
        this.radius = radius;
        this.center = center;
    }

    public Point3D getCenter() {
        return center;
    }

    @Override
    public Vector getNormal(Point3D p) {
        Vector N = p.subtract(center);
        N.normalize();
        return N;
    }

    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray) {
        double tm;
        double d;
        if(ray.getP0().equals(center)) {
            tm = 0;
            d = 0;
        }
        else {
            Vector u = center.subtract(ray.getP0());
            Vector v = ray.getDir();
            tm = u.dotProduct(v);
            d = alignZero(Math.sqrt(u.lengthSquared() - tm * tm));
        }


        if (d > this.radius) {
            return null;
        }
        double th = alignZero(Math.sqrt(this.radius * this.radius - d * d));
        if (isZero(th)) {
            return null;
        }
        double t1 = alignZero(tm + th);
        double t2 = alignZero(tm - th);

        if (t1 > 0 && t2 > 0) {
            return List.of(new GeoPoint(this, ray.getPoint(t1)), new GeoPoint(this, ray.getPoint(t2)));

        }
        if (t1 > 0) {
            return List.of(new GeoPoint(this, ray.getPoint(t1)));

        }
        if (t2 > 0) {
            return List.of(new GeoPoint(this, ray.getPoint(t2)));

        }
        return null;
    }
}
