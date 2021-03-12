package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

/**
 * basic geometric object for Sphere
 */
public class Tube implements Geometry{
    final Ray axisRay;
    final double radius;

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
        Vector p_p0  = p.subtract(axisRay.getP0());
        double t = axisRay.getDir().dotProduct(p_p0);

        Point3D o = axisRay.getP0().add(p_p0.scale(t));
        Vector N = p.subtract(o);

        N.normalize();
        return N;
    }
}
