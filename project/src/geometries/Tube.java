package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * basic geometric object for Sphere
 */
public class Tube extends Geometry{
    final Ray axisRay;
    final double radius;

    /**
     * constructor
     * @param axisRay Ray
     * @param radius double
     */
    public Tube(Ray axisRay, double radius) {
        this.radius = radius;
        this.axisRay = axisRay;
    }

    /**
     * get ray
     * @return axisRay
     */
    public Ray getAxisRay() {
        return axisRay;
    }

    /**
     * make String
     * @return"Tube{axisRay=" + axisRay + ", radius=" + this.radius + '}'
     */
    @Override
    public String toString() {
        return "Tube{" +
                "axisRay=" + axisRay +
                ", radius=" + this.radius +
                '}';
    }

     /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    @Override
    public Vector getNormal(Point3D p) {
        Vector p_p0  = p.subtract(axisRay.getP0());
        double t = axisRay.getDir().dotProduct(p_p0);

        Point3D o = axisRay.getP0().add(p_p0.scale(t));
        Vector N = p.subtract(o);

        N.normalize();
        return N;
    }

    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object
     * @param maxDistance the max distance
     * @return the intersections with the object
     */
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
        return null;
    }
}
