package renderer;

import elements.LightSource;
import primitives.Color;
import primitives.Material;
import primitives.Ray;

import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;

import primitives.Vector;
import scene.Scene;

import java.util.List;

public class BasicRayTracer extends BaseRayTracer {

    public BasicRayTracer(Scene scene) {
        super(scene);
    }

    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = this.scene.geometries.findGeoIntersections(ray);
        if (intersections != null) {
            GeoPoint closestGeoPoint = ray.getClosestGeoPoint(intersections);
            return calcColor(closestGeoPoint, ray);
        }
        //ray did not intersect any geometrical object
        return this.scene.background;
    }

    private Color calcColor(GeoPoint geoPoint, Ray ray) {
        Color emissionColor = geoPoint.geometry.getEmission();
        Color basicColor = this.scene.ambientLight.getIntensity().add(emissionColor);
        return basicColor.add(calcLocalEffect(geoPoint, ray));
    }

    private Color calcLocalEffect(GeoPoint geoPoint, Ray ray) {
        Vector v = ray.getDir ();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) {
            return Color.BLACK;
        }
        Material material = geoPoint.geometry.getMaterial();
        int nShininess = material.getnShininess();
        Color color = Color.BLACK;
        for (LightSource lightSource : scene.lights) {
            Vector l = lightSource.getL(geoPoint.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) { // sign(nl) == sing(nv)
                Color lightIntensity = lightSource.getIntensity(geoPoint.point);
                color = color.add(calcDiffusive(material.Kd, l, n, lightIntensity),
                        calcSpecular(material.Ks, l, n, v, nShininess, lightIntensity));
            }
        }
        return color;
    }

    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        Vector r = l.subtract(n.scale(l.dotProduct(n)*2));
        double vrMinus = v.scale(-1).dotProduct(r);
        double vrn = Math.pow(vrMinus, nShininess);
        return lightIntensity.scale(ks*vrn);
    }

    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        double ln = Math.abs(l.dotProduct(n));
        return lightIntensity.scale(kd*ln);
    }
}

