package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

/**
 * basic geometric object for Sphere
 */
public class Tube extends RadialGeometry implements Geometry{
    final Ray axisRay;

    /**
     *
     * @param axisRay Ray
     * @param radius double
     */
    public Tube(Ray axisRay, double radius) {
        super(radius);
        this.axisRay = axisRay;
    }

    public Ray getAxisRay() {
        return axisRay;
    }

    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + radius +
                '}';
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

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return null;
    }
}
