package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

/**
 * basic geometric object for Cylinder
 */
public class Cylinder extends Tube{
    double height;

    /**
     * @param axisRay Ray axisRay
     * @param radius double radius
     * @param height double height
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
        this.height = height;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public Vector getNormal(Point3D p) {
        return null;
    }
}
