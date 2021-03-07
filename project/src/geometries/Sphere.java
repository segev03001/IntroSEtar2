package geometries;

import Primitives.Point3D;
import Primitives.Vector;

/**
 * basic geometric object for Sphere
 */
public class Sphere implements Geometry{

    Point3D center;
    double radios;

    /**
     *
     * @param center Point3D
     * @param radios double
     */
    public Sphere(Point3D center, double radios) {
        this.center = center;
        this.radios = radios;
    }

    public Point3D getCenter() {
        return center;
    }

    public double getRadios() {
        return radios;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
