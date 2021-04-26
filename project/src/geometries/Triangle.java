package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

/**
 * basic geometric object for Sphere
 */
public class Triangle extends Polygon {
    Point3D p1;
    Point3D p2;
    Point3D p3;

    public Triangle(Point3D... vertices) {
        super(vertices);
        if (vertices.length != 3)
            throw new IllegalArgumentException("A Triangle must have 3 vertices");
        p1 = vertices[0];
        p2 = vertices[1];
        p3 = vertices[2];
    }

    @Override
    public Vector getNormal(Point3D p) {
        return super.getNormal(p);
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
