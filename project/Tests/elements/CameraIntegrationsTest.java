package elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;
import geometries.Intersectable;
import geometries.Plane;
import geometries.Sphere;
import geometries.Triangle;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CameraIntegrationsTest {


    /**
     * function to help count and compare intersections
     * @param cam is camera
     * @param geo body for intersections
     * @param expected amount of intersections
     */
    private void assertCountIntersections(Camera cam, Intersectable geo, int expected){
        int count = 0;
        cam.setViewPlaneSize(3, 3).setDistance(1);
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 3; ++j) {
                var intersections = geo.findIntersections(cam.constructRayThroughPixel(3, 3, j, i));
                count += intersections == null ? 0 : intersections.size();
            }
        }
            assertEquals(expected, count, "wrong amount of intersection");
    }

    /**
     * test intersections of sphere with cam
     */
    @Test
    void testSphere1WithCam() {
        Camera cam1 = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, -1, 0));
        Camera cam2 = new Camera(new Point3D(0, 0, 0.5), new Vector(0, 0, -1), new Vector(0, -1, 0));

        //2 points
        assertCountIntersections(cam1,new Sphere(1, new Point3D(0,0,-3)), 2);

        //18 points
        assertCountIntersections(cam2,new Sphere(2.5, new Point3D(0,0,-2.5)), 18);

        //10 points
        assertCountIntersections(cam2,new Sphere(2, new Point3D(0,0,-2)), 10);

        //9 points
        assertCountIntersections(cam2,new Sphere(4, new Point3D(0,0,-1)), 9);

        //0 points
        assertCountIntersections(cam1,new Sphere(0.5, new Point3D(0,0,1)), 0);
    }

    /**
     * test intersections of plane with cam
     */
    @Test
    public void testPlane1WithCam(){
        Camera cam = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, -1, 0));
        // 9 points
        assertCountIntersections(cam, new Plane(new Point3D(0,0,-5), new Vector(0,0,1)), 9);
        // 9 points
        assertCountIntersections(cam, new Plane(new Point3D(0,0,-5), new Vector(0,0,2)), 9);
        // 6 points
        assertCountIntersections(cam, new Plane(new Point3D(0,0,-5), new Vector(0,1,1)), 6);
    }

    /**
     * test intersections of triangle with cam
     */
    @Test
    public void testPTriangle1WithCam(){
        Camera cam = new Camera(Point3D.ZERO, new Vector(0, 0, -1), new Vector(0, -1, 0));
        //1 points
        assertCountIntersections(cam, new Triangle(new Point3D(1,1,-2), new Point3D(-1,1,-2), new Point3D(0,-1,-2)), 1);
        //2 points
        assertCountIntersections(cam, new Triangle(new Point3D(1,1,-2), new Point3D(-1,1,-2), new Point3D(0,-20,-2)), 2);
    }
}
