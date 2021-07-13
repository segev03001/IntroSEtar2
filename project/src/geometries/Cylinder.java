package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

/**
 * basic geometric object for Cylinder
 */
public class Cylinder extends Tube{
    final double height;

    /**
     * @param axisRay Ray axisRay
     * @param radius double radius
     * @param height double height
     */
    public Cylinder(Ray axisRay, double radius, double height) {
        super(axisRay, radius);
       this.height = height;
    }

    /**
     * get height
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    @Override
    public Vector getNormal(Point3D p) {
        return super.getNormal(p);
    }
}
