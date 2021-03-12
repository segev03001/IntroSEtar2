package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testing Sphere
 *
 * @author segev and shilo
 *
 */

class SphereTest {

    /**
     * Test method for {@link Sphere#getNormal(Point3D)}  .
     */
    @Test
    void getNormal() {
        Sphere sp = new Sphere(new Point3D(0,1,0),2d);

        assertEquals(sp.getNormal(new Point3D(0,0,0)), new Vector(0,-1,0));
    }
}