package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

/**
 * basic geometric object for Sphere
 */
public class Triangle extends Polygon {
    Point3D p1;
    Point3D p2;
    Point3D p3;

    /**
     * constructor with a list of three points
     * @param vertices
     */
    public Triangle(Point3D... vertices) {
        super(vertices);
        if (vertices.length != 3)
            throw new IllegalArgumentException("A Triangle must have 3 vertices");
        p1 = vertices[0];
        p2 = vertices[1];
        p3 = vertices[2];
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

    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object.
     * @return the intersections with the object
     */
    @Override
    public List<Point3D> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
