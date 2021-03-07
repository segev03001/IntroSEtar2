package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

/**
 * basic geometric object for Sphere
 */
public class Tube implements Geometry{
    Ray axisRay;
    double radius;

    /**
     *
     * @param axisRay Ray
     * @param radius double
     */
    public Tube(Ray axisRay, double radius) {
        this.axisRay = axisRay;
        this.radius = radius;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
