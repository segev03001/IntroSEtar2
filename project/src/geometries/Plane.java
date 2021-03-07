package geometries;

import Primitives.Point3D;
import Primitives.Vector;

/**
 * basic geometric object for Plane
 */
public class Plane implements Geometry{
    Point3D q0;
    Vector normal;

    /**
     * make plane with three points
     * @param q0 Point3D
     * @param normal Vector
     */
    public Plane(Point3D q0, Vector normal) {
        this.q0 = q0;
        this.normal = normal;
    }

    /**
     * make plane with three points
     * @param p1 Point3D
     * @param p2 Point3D
     * @param p3 Point3D
     */
    public Plane(Point3D p1, Point3D p2, Point3D p3) {
        this.q0 = p1;
        normal = null;
    }

    public Point3D getQ0() {
        return q0;
    }

    public Vector getNormal() {
        return normal;
    }

    @Override
    public String toString() {
        return "Plane{" +
                "q0=" + q0 +
                ", normal=" + normal +
                '}';
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
