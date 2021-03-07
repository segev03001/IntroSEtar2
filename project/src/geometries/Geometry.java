package geometries;

import Primitives.Vector;
import Primitives.Point3D;

public interface Geometry {
    /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    public Vector getNormal(Point3D p);
}
