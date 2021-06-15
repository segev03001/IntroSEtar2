package renderer;

import Primitives.Color;
import Primitives.Point3D;
import Primitives.Ray;
import scene.Scene;

import java.util.List;

public class RayTracerBasic extends RayTracerBase {

    public RayTracerBasic(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<Point3D> intersections = this.scene.geometries.findIntersections(ray);
        if (intersections != null) {
            Point3D closestPoint = ray.getClosestPoint(intersections);
            return calcColor(closestPoint);
        }
        //ray did not intersect any geometrical object
        return this.scene.background;
    }

    private Color calcColor(Point3D point) {
        return this.scene.ambientLight.getIntesity();
    }
}

