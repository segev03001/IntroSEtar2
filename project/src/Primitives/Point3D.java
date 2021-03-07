package Primitives;

import java.util.Objects;

/**
 * basic geometric object for 3d Point
 */
public class Point3D {
    Coordinate x;
    Coordinate y;
    Coordinate z;

    static public Point3D ZERO = new Point3D(0, 0, 0);

    /**
     * @param x coordinates for X axis
     * @param y coordinates for Y axis
     * @param z coordinates for Z axis
     */
    public Point3D(Coordinate x, Coordinate y, Coordinate z) {
        this(x.coord, y.coord, z.coord);
    }

    /**
     * @param x coordinates for X axis
     * @param y coordinates for Y axis
     * @param z coordinates for Z axis
     */
    public Point3D(double x, double y, double z) {
        this.x = new Coordinate(x);
        this.y = new Coordinate(y);
        this.z = new Coordinate(z);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point3D point3D = (Point3D) o;
        return x.equals(point3D.x) && y.equals(point3D.y) && z.equals(point3D.z);
    }

    @Override
    public int hashCode() {
        return Objects.hash(x.coord, y.coord, z.coord);
    }

    /**
     * @param p point for distance calculation
     * @return the distance between points by formula
     */
    public double distanceSquared(Point3D p) {
        double x1 = x.coord;
        double x2 = p.x.coord;
        double y1 = y.coord;
        double y2 = p.y.coord;
        double z1 = z.coord;
        double z2 = p.z.coord;

        return (x2 - x2) * (x2 - x1) + (y2 - y2) * (y2 - y1) + (z2 - z2) * (z2 - z1);
    }

    /**
     * @param p point for distance
     * @return squre distance
     */
    public double distance(Point3D p) {
        return Math.sqrt((distanceSquared(p)));
    }

    /**
     * add vector to point
     * @param v vector to add
     * @return new point after adding
     */
    public Point3D add(Vector v) {
        return new Point3D(
                x.coord + v.head.x.coord,
                y.coord + v.head.y.coord,
                z.coord + v.head.z.coord);
    }

    /**
     * subtraction of point from point by formula
     * @param p point to subtraction
     * @return new vector after subtraction
     */
    public Vector subtract(Point3D p){
        return new Vector(x.coord - p.x.coord,
                          y.coord - p.y.coord,
                          z.coord - p.z.coord);
    }
}
