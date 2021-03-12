package geometries;

import Primitives.Point3D;
import Primitives.Vector;

/**
 * basic geometric object for Sphere
 */
public class Triangle extends Polygon {
    public Triangle(Point3D... vertices) {
        super(vertices);
    }

    @Override
    public Vector getNormal(Point3D p) {
        return super.getNormal(p);
    }
}
