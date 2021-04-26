package geometries;

import Primitives.Point3D;
import Primitives.Ray;

import java.util.List;

public interface Intersectable {
    /**
     *
     * @param ray the ray from the camera
     * @return the intersections with the object
     */
    List<Point3D> findIntersections(Ray ray);
}
