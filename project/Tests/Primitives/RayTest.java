package Primitives;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RayTest {
    Ray ray = new Ray(Point3D.ZERO, new Vector(0, 0, 1));

    @Test
    void getClosestPointEP1() {
        List<Point3D> point3DS = new LinkedList<>();
        point3DS.add(new Point3D(-1000, 90, 100));
        point3DS.add(new Point3D(50, 48, 1000));
        point3DS.add(new Point3D(0, .5, 1));
        point3DS.add(new Point3D(-20, 60, 50));
        point3DS.add(new Point3D(0, 0, -90));
        assertEquals(point3DS.get(2), ray.getClosestPoint(point3DS), "points do not match");
    }
    @Test
    void getClosestPointBVA1() {
        assertNull(ray.getClosestPoint(null), "supposed to be null");
    }
    @Test
    void getClosestPointEP2() {
        List<Point3D> point3DS = new LinkedList<>();
        point3DS.add(new Point3D(-1000, 90, 100));
        point3DS.add(new Point3D(50, 48, 1000));
        point3DS.add(new Point3D(-20, 60, 50));
        point3DS.add(new Point3D(0, 0, -90));
        point3DS.add(new Point3D(0, .5, 1));
        assertEquals(point3DS.get(4), ray.getClosestPoint(point3DS), "points do not match");
    }
    @Test
    void getClosestPointEP3() {
        List<Point3D> point3DS = new LinkedList<>();
        point3DS.add(new Point3D(0, .5, 1));
        point3DS.add(new Point3D(-1000, 90, 100));
        point3DS.add(new Point3D(50, 48, 1000));
        point3DS.add(new Point3D(-20, 60, 50));
        point3DS.add(new Point3D(0, 0, -90));
        assertEquals(point3DS.get(0), ray.getClosestPoint(point3DS), "points do not match");
    }
}