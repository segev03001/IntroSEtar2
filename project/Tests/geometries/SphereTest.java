package geometries;

import Primitives.*;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Sphere
 *
 * @author segev and shilo
 */

class SphereTest {

    /**
     * Test method for {@link Sphere#getNormal(Point3D)}  .
     */
    @Test
    void getNormal() {
        Sphere sp = new Sphere(2d, new Point3D(0, 1, 0));

        assertEquals(sp.getNormal(new Point3D(0, 0, 0)), new Vector(0, -1, 0));
    }

    /**
     * Test method for {@link geometries.Sphere#findIntersections(Primitives.Ray)}.
     */
    @Test
    public void testFindIntersections() {
        Sphere sphere = new Sphere(1d, new Point3D(1, 0, 0));

        // ============ Equivalence Partitions Tests ==============

        // TC01: Ray's line is outside the sphere (0 points)
        assertNull(sphere.findIntersections(new Ray
                (new Point3D(-1, 0, 0),
                        new Vector(1, 1, 0))), "Ray's line out of sphere");

        // TC02: Ray starts before and crosses the sphere (2 points)
        Point3D p1 = new Point3D(0.0651530771650466, 0.355051025721682, 0);
        Point3D p2 = new Point3D(1.53484692283495, 0.844948974278318, 0);
        List<Point3D> result = sphere.findIntersections(
                new Ray(new Point3D(-1, 0, 0),
                        new Vector(3, 1, 0)
                )
        );
        assertEquals(2, result.size(), "Wrong number of points");

        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals(List.of(p1, p2), result, "Ray crosses sphere");

        // TC03: Ray starts inside the sphere (1 point)
        Point3D p3 = new Point3D(1.5,0,0);
        Point3D p4 = new Point3D(2,0,0);

        result =  sphere.findIntersections(new Ray(p3,new Vector(1,0,0)));
        assertEquals(1,result.size(), "Wrong number of points");
        assertEquals(p4,result.get(0), "Not Expected intersection");

        // TC04: Ray starts after the sphere (0 points)
        result = sphere.findIntersections(new Ray(new Point3D(3,0,0), new Vector(1,0,1)));
        assertNull(result, "Ray isn't supposed to be intersecting when it starts after the sphere");

        // =============== Boundary Values Tests ==================

        // ** Group: Ray's line crosses the sphere (but not the center)
        // TC11: Ray starts at sphere and goes inside (1 points)
        Point3D p5 = new Point3D(0.370623010149871, -0.420780618391563, 0.653320959278979);
        result = sphere.findIntersections(new Ray(p4, new Vector(-1.629376989850129,-0.420780618391563,0.653320959278979)));
        assertEquals(1,result.size(), "Wrong number of points");
        assertEquals(p5, result.get(0), "Not Expected intersection when ray starts at sphere and goes inside");

        // TC12: Ray starts at sphere and goes outside (0 points)
        result = sphere.findIntersections(new Ray(p4, new Vector(1,0,1)));
        assertNull(result, "Ray isn't supposed to be intersecting when it starts at the sphere and goes outside");

        // ** Group: Ray's line goes through the center
        // TC13: Ray starts before the sphere (2 points)
        p1 = Point3D.ZERO;
        result = sphere.findIntersections(new Ray(new Point3D(-1,0,0), new Vector(1,0,0)));
        assertEquals(2, result.size(),"Wrong number of points");
        if (result.get(0).getX() > result.get(1).getX())
            result = List.of(result.get(1), result.get(0));
        assertEquals( List.of(p1, p4), result,"Not expected intersections when ray starts before the sphere and goes through the center");

        // TC14: Ray starts at sphere and goes inside (1 points)
        result = sphere.findIntersections(new Ray(p1, new Vector(1,0,0)));
        assertEquals(1,result.size(), "Wrong number of points");
        assertEquals(p4, result.get(0), "Not expected intersection when ray starts at sphere and goes through the center");

        // TC15: Ray starts inside (1 points)
        result = sphere.findIntersections(new Ray(new Point3D(0.5,0,0), new Vector(1,0,0)));
        assertEquals(1,result.size(), "Wrong number of points");
        assertEquals(p4, result.get(0), "Not expected intersection when ray starts inside sphere and goes through the center");

        // TC16: Ray starts at the center (1 points)
        result = sphere.findIntersections(new Ray(sphere.center, new Vector(1,0,0)));
        assertEquals(1,result.size(), "Wrong number of points");
        assertEquals(p4, result.get(0), "Not expected intersection when ray starts at the center of the sphere");

        // TC17: Ray starts at sphere and goes outside (0 points)
        result = sphere.findIntersections(new Ray(p4, new Vector(1,0,0)));
        assertNull(result, "Ray isn't supposed to be intersecting when it starts at the sphere and goes outside on the same line as the center");

        // TC18: Ray starts after sphere (0 points)
        result = sphere.findIntersections(new Ray(new Point3D(3,0,0), new Vector(1,0,0)));
        assertNull(result, "Ray isn't supposed to be intersecting when it starts after the sphere on the same line as the center");

        // ** Group: Ray's line is tangent to the sphere (all tests 0 points)
        // TC19: Ray starts before the tangent point
        result = sphere.findIntersections(new Ray(new Point3D(2,-1,0), new Vector(0,1,0)));
        assertNull(result, "Ray isn't supposed to have intersections when the ray tangent and starts before the tangent point");

        // TC20: Ray starts at the tangent point
        result = sphere.findIntersections(new Ray(new Point3D(2,0,0), new Vector(0,1,0)));
        assertNull(result, "Ray isn't supposed to have intersections when the ray tangent and starts at the tangent point");

        // TC21: Ray starts after the tangent point
        result = sphere.findIntersections(new Ray(new Point3D(2,1,0), new Vector(0,1,0)));
        assertNull(result, "Ray isn't supposed to have intersections when the ray tangent and starts after the tangent point");

        // ** Group: Special cases
        // TC19: Ray's line is outside, ray is orthogonal to ray start to sphere's center line
        result = sphere.findIntersections(new Ray(new Point3D(-1,1,0), new Vector(0,1,0)));
        assertNull(result, "Ray isn't supposed to have intersections when it's orthogonal to the sphere's center line");

    }


}