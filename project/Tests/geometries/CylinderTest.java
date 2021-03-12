package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Testing Cylinder
 *
 * @author segev and shilo
 *
 */
class CylinderTest {

    /**
     * Test method for {@link geometries.Cylinder#getNormal(Primitives.Point3D)}.
     */
    @Test
    void getNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Ray ray = new Ray(new Point3D(0,1,0),new Vector(0,1,0));
        Cylinder tb = new Cylinder(ray, 2, 10);

        assertEquals(tb.getNormal(new Point3D(0,0,0)), new Vector(0,-1,0));
    }
}