package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import java.util.List;

import static Primitives.Util.alignZero;
import static Primitives.Util.isZero;

/**
 * basic geometric object for Sphere
 */
public class Sphere extends RadialGeometry implements Geometry {

    Point3D center;

    /**
     * @param center Point3D
     * @param radios double
     */
    public Sphere(double radios, Point3D center) {
        super(radios);
        this.center = center;
    }

    public Point3D getCenter() {
        return center;
    }

    @Override
    public Vector getNormal(Point3D p) {
        Vector N = p.subtract(center);
        N.normalize();
        return N;
    }

    @Override
    public List<Point3D> findIntersections(Ray ray) {
        double tm;
        double d;
        if(ray.getP0().equals(center)) {
            tm = 0;
            d = 0;
        }
        else {
            Vector u = center.subtract(ray.getP0());
            Vector v = ray.getDir();
            tm = u.dotProduct(v);
            d = alignZero(Math.sqrt(u.lengthSquared() - tm * tm));
        }


        if (d > radius) {
            return null;
        }
        double th = alignZero(Math.sqrt(radius * radius - d * d));
        if (isZero(th)) {
            return null;
        }
        double t1 = alignZero(tm + th);
        double t2 = alignZero(tm - th);

        if (t1 > 0 && t2 > 0) {
            return List.of(ray.getPoint(t1), ray.getPoint(t2));

        }
        if (t1 > 0) {
            return List.of(ray.getPoint(t1));

        }
        if (t2 > 0) {
            return List.of(ray.getPoint(t2));

        }
        return null;
    }
}
