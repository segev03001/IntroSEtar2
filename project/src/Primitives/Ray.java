package Primitives;

import java.util.Objects;

public class Ray {
    Point3D p0;
    Vector dir;

    public Ray(Point3D p0, Vector dir) {
        this.dir = dir.normalized();
        this.p0 = new Point3D(p0.x,p0.y, p0.z);
    }

    public Point3D getP0() {
        return p0;
    }

    public Vector getDir() {
        return dir;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ray ray = (Ray) o;
        return p0.equals(ray.p0) && dir.equals(ray.dir);
    }

    @Override
    public int hashCode() {
        return Objects.hash(p0, dir);
    }
}
