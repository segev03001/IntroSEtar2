package primitives;

import java.util.Objects;

import static primitives.Point3D.ZERO;

/**
 * basic geometric object for vector
 */
public class Vector {
    Point3D head;

    /**
     * constructor
     * @param head point 3d
     */
    public Vector(Point3D head) {
        this(head.x.coord, head.y.coord, head.z.coord);
    }

    /**
     * constructor by three coordinates
     * @param x coordinates for X axis
     * @param y coordinates for Y axis
     * @param z coordinates for Z axis
     */
    public Vector(Coordinate x, Coordinate y, Coordinate z) {
        if ((new Point3D(x, y, z)).equals(ZERO))
            throw new IllegalArgumentException("head cannot be Point(0,0,0)");
        ;
        this.head = new Point3D(x, y, z);
    }

    /**
     * constructor by three double
     * @param x coordinates for X axis
     * @param y coordinates for Y axis
     * @param z coordinates for Z axis
     */
    public Vector(double x, double y, double z) {
        if ((new Point3D(x, y, z)).equals(ZERO))
            throw new IllegalArgumentException("head cannot be Point(0,0,0)");
        ;
        this.head = new Point3D(x, y, z);
    }

    /**
     * @return the point of the vector
     */
    public Point3D getHead() {
        return new Point3D(head.x, head.y, head.z);
    }

    /**
     * @param v the adding vector
     * @return new vector bt add formula
     */
    public Vector add(Vector v) {
        return new Vector(
                head.x.coord + v.head.x.coord,
                head.y.coord + v.head.y.coord,
                head.z.coord + v.head.z.coord);
    }

    /**
     * subtract 2 vector
     *
     * @param v vector to subtract
     * @return the result of subtract between vectors
     */
    public Vector subtract(Vector v) {
        return new Vector(head.x.coord - v.head.x.coord,
                head.y.coord - v.head.y.coord,
                head.z.coord - v.head.z.coord);
    }

    /**
     * multiplication vector with scalar
     *
     * @param d double
     * @return multiplication's result
     */
    public Vector scale(double d) {
        return new Vector(
                head.x.coord * d,
                head.y.coord * d,
                head.z.coord * d);
    }

    /**
     * Makes a scalar product between vectors
     * @param v vector
     * @return scalar product
     */
    public double dotProduct(Vector v) {
        return (head.x.coord * v.head.x.coord +
                head.y.coord * v.head.y.coord +
                head.z.coord * v.head.z.coord);
    }

    /**
     * Makes a vector product between vectors
     * @param v vector
     * @return vector product
     */
    public Vector crossProduct(Vector v)  {
        Point3D newhead = new Point3D(
                (head.y.coord * v.head.z.coord) - (head.z.coord * v.head.y.coord),
                (head.z.coord * v.head.x.coord) - (head.x.coord * v.head.z.coord),
                (head.x.coord * v.head.y.coord) - (head.y.coord * v.head.x.coord));
        if (newhead.equals(ZERO)){
            throw new IllegalArgumentException("cross product resulting Zero point head");
        }
        return new Vector(newhead);
    }

    /**
     * Calculate the length of the vector squared
     * @return the length of the vector squared
     */
    public double lengthSquared() {
        return ((head.x.coord * head.x.coord) + (head.y.coord * head.y.coord) + (head.z.coord * head.z.coord));
    }

    /**
     * Calculate the length of the vector
     * @return the length of the vector
     */
    public double length() {
        return Math.sqrt(lengthSquared());
    }

    /**
     * The vector normalization action that will change the vector itself
     * @return Another vector is normalized
     */
    public Vector normalize() {
        double x = head.x.coord;
        double y = head.y.coord;
        double z = head.z.coord;
        double l = this.length();

        this.head = new Point3D(x / l, y / l, z / l);
        return this;
    }

    /**
     * Normalization operation
     * @return Returns a normalized new vector in the same direction as the original vector
     */
    public Vector normalized() {
        return new Vector(this.normalize().head);
    }

    /**
     * Check when the vectors are equal
     * @param o Another vector
     * @return false if they are different and true if they are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vector vector = (Vector) o;
        return head.equals(vector.head);
    }

    /**
     * hash function
     * @return the hash number
     */
    @Override
    public int hashCode() {
        return Objects.hash(head);
    }
}
