package Primitives;

import static org.junit.jupiter.api.Assertions.*;

class Point3DTest {

    Point3D p1 = new Point3D(1.0d,2.0d,3.0d);
    Point3D p2 = new Point3D(1.00000000000000001d,2.0d,3.0d);

    @org.junit.jupiter.api.Test
    void testEquals() {
        assertEquals(p1,p2);
    }

    @org.junit.jupiter.api.Test
    void distanceSquared() {
    }
}