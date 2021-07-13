package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * basic geometric object for Plane
 */
public class Plane extends Geometry {
    final Point3D q0;
    final Vector normal;

    /**
     * make plane with three points
     * @param q0     Point3D
     * @param normal Vector
     */
    public Plane(Point3D q0, Vector normal) {
        this.q0 = q0;
        this.normal = normal.normalized();
    }

    /**
     * make plane with three points
     *
     * @param p1 Point3D
     * @param p2 Point3D
     * @param p3 Point3D
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this.q0 = p1;

        Vector u = p2.subtract(p1);
        Vector v = p3.subtract(p1);

        Vector n = u.crossProduct(v);
        n.normalize();
        this.normal = n;
    }

    /**
     * get Point3D
     * @return q0
     */
    public Point3D getQ0() {
        return q0;
    }

    /**
     * get Vector
     * @return normal
     */
    public Vector getNormal() {
        return normal;
    }

    /**
     * make String
     * @return "Plane{" + "q0=" + q0 + ", normal=" + normal + '}'
     */
    @Override
    public String toString() {
        return "Plane{" +
                "q0=" + q0 +
                ", normal=" + normal +
                '}';
    }

     /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    @Override
    public Vector getNormal(Point3D p) {
        return this.normal;
    }

    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object
     * @param maxDistance the max distance
     * @return the intersections with the object
     */
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
        Point3D P0 = ray.getP0();
        Vector v = ray.getDir();

        if (q0.equals(P0)) {
            return null;
        }
        double nv = alignZero(normal.dotProduct(v));

        // the ray is lying on the plane
        if (isZero(nv)) {
            return null;
        }
        double t = alignZero(normal.dotProduct(q0.subtract(P0)));
        if (isZero(t)) {
            return null;
        }
        t /= nv;
        if (t < 0) {
            return null;
        }
        if (alignZero(t - maxDistance) <= 0) {
            Point3D p = ray.getPoint(t);
            return List.of(new GeoPoint(this, p));
        }

        return null;
    }
}

