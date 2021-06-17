package geometries;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/**
 * Testing Tube
 *
 * @author segev and shilo
 *
 */
class TubeTest {
    /**
     * Test method for {@link Tube#getNormal(Point3D)}  .
     */
    @Test
    void getNormal() {
        Ray ray = new Ray(new Point3D(0,1,0),new Vector(0,1,0));
        Tube tb = new Tube(ray, 2);

        assertEquals(tb.getNormal(new Point3D(0,0,0)), new Vector(0,-1,0));
    }
}