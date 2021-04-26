package geometries;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GeometriesTest {
    List<Point3D> result;
    Geometries geometries = new Geometries();

    @Test
    void findIntersections() {
        // =============== Boundary Values Tests ==================

        // TC01: geometries is empty (0 points)
        result = geometries.findIntersections(new Ray(new Point3D(3, 1,0),
                new Vector(1,0,1)));
        assertNull(result, "Wrong number of points");

        // TC02: geometries is not intersection (0 points)
        geometries.add(new Plane(new Point3D(3,3,1), new Point3D(2,3,2), new Point3D(1,1,1)));
        result = geometries.findIntersections(new Ray(new Point3D(4, 4, 4),
                new Vector(1,1,0)));
        assertNull(result, "Wrong number of points");
        }
    }