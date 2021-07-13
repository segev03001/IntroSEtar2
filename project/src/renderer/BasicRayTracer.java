package renderer;

import elements.LightSource;
import primitives.*;
import static geometries.Intersectable.GeoPoint;
import static primitives.Util.alignZero;
import scene.Scene;
import java.util.List;

/**
 * BasicRayTracer that extend BaseRayTracer
 */
public class BasicRayTracer extends BaseRayTracer {

    private static final double DELTA = 0.1;
    private static final double INITIAL_K = 1.0;
    private static final int MAX_CALC_COLOR_LEVEL = 10;
    private static final double MIN_CALC_COLOR_K = 0.001;

    /**
     * constructor for BasicRayTracer with scene
     * use the super function
     * @param scene for scene
     */
    public BasicRayTracer(Scene scene) {
        super(scene);
    }

    /**
     * abstract function that get ray and return color
     * @param ray the ray
     * @return the color
     */
    @Override
    public Color traceRay(Ray ray) {
        List<GeoPoint> intersections = this.scene.geometries.findGeoIntersections(ray);
        if (intersections != null) {
            GeoPoint closestGeoPoint = ray.getClosestGeoPoint(intersections);
            return calcColor(closestGeoPoint, ray)
                            .add(closestGeoPoint.geometry.getEmission());
        }
        //ray did not intersect any geometrical object
        return this.scene.background;
    }

    /**
     * calculate the color of the closestPoint to the ray with the color of the ambient light
     * @param closestPoint
     * @param ray
     * @return the combine color
     */
    private Color calcColor(GeoPoint closestPoint, Ray ray) {
        return calcColor(closestPoint, ray, MAX_CALC_COLOR_LEVEL, INITIAL_K)
                .add(this.scene.ambientLight.getIntensity());
    }

    /**
     * calculate the color of the closestPoint to the ray with the color of the ambient light and the emission
     * @param intersection GeoPoint
     * @param ray Ray
     * @param level int
     * @param k double
     * @return the combine color
     */
    private Color calcColor(GeoPoint intersection, Ray ray, int level, double k) {
            Color color = intersection.geometry.getEmission();
            color = color.add(calcLocalEffects(intersection, ray));
            return 1 == level ? color : color.add(calcGlobalEffects(intersection, ray.getDir(), level, k));
    }

    /**
     * calculate the color with the effect of environment
     * @param geoPoint GeoPoint
     * @param ray Ray
     * @return the combine color
     */
    private Color calcLocalEffects(GeoPoint geoPoint, Ray ray) {
        Vector v = ray.getDir();
        Vector n = geoPoint.geometry.getNormal(geoPoint.point);
        double nv = alignZero(n.dotProduct(v));
        if (nv == 0) {
            return Color.BLACK;
        }
        Material material = geoPoint.geometry.getMaterial();
        int nShininess = material.getnShininess();
        Color color = Color.BLACK;
        for (LightSource lightSource : this.scene.lights) {
            Vector l = lightSource.getL(geoPoint.point);
            double nl = alignZero(n.dotProduct(l));
            if (nl * nv > 0) {
                if (unshaded(lightSource,l, n, geoPoint)) {
                    Color lightIntensity = lightSource.getIntensity(geoPoint.point);
                    color = color.add(calcDiffusive(material.Kd, l, n, lightIntensity),
                            calcSpecular(material.Ks, l, n, v, nShininess, lightIntensity));
                }
            }
        }
        return color;
    }

    /**
     * calculate the position if it unshaded or not
     * @param light the light source
     * @param l
     * @param n
     * @param geopoint
     * @return true if it not shaded anf false if it shaded
     */
    private boolean unshaded(LightSource light, Vector l, Vector n, GeoPoint geopoint) {
        Vector lightDirection = l.scale(-1); // from point to light source
        //Ray from point toward light direction offset by delta
        Ray lightRay = new Ray(geopoint.point, lightDirection, n, DELTA);
        //
        double distance = light.getDistance(geopoint.point);
        List<GeoPoint> intersections = this.scene.geometries.findGeoIntersections(lightRay,distance);
        return intersections == null;
    }

    /**
     * calculate the specular
     * @param ks
     * @param l
     * @param n
     * @param v
     * @param nShininess
     * @param lightIntensity
     * @return
     */
    private Color calcSpecular(double ks, Vector l, Vector n, Vector v, int nShininess, Color lightIntensity) {
        Vector r = l.subtract(n.scale(l.dotProduct(n) * 2));
        double vrMinus = v.scale(-1).dotProduct(r);
        double vrn = Math.pow(vrMinus, nShininess);
        return lightIntensity.scale(ks * vrn);
    }

    /**
     * calculate the diffusive
     * @param kd
     * @param l
     * @param n
     * @param lightIntensity
     * @return
     */
    private Color calcDiffusive(double kd, Vector l, Vector n, Color lightIntensity) {
        double ln = Math.abs(l.dotProduct(n));
        return lightIntensity.scale(kd * ln);
    }

    /**
     * calculate global effects
     * @param gp
     * @param v
     * @param level
     * @param k
     * @return
     */
    private Color calcGlobalEffects(GeoPoint gp, Vector v, int level, double k) {
        Color color = Color.BLACK;
        Vector n = gp.geometry.getNormal(gp.point);
        Material material = gp.geometry.getMaterial();
        double kkr = k * material.kr;
        if (kkr > MIN_CALC_COLOR_K)
            color = calcGlobalEffect(constructReflectedRay(gp.point, v, n), level, material.kr, kkr);
        double kkt = k * material.kt;
        if (kkt > MIN_CALC_COLOR_K)
            color = color.add(calcGlobalEffect(constructRefractedRay(gp.point, v), level, material.kt, kkt));
        return color;
    }

    /**
     * calculate global effects
     * @param ray
     * @param level
     * @param kx
     * @param kkx
     * @return
     */
    private Color calcGlobalEffect(Ray ray, int level, double kx, double kkx) {
        GeoPoint gp = ray.getClosestGeoPoint(this.scene.geometries.findGeoIntersections(ray));
        return (gp == null ? scene.background : calcColor(gp, ray, level - 1, kkx)
        ).scale(kx);
    }

    /**
     * calculate the construct of the refracted ray
     * @param point
     * @param v
     * @return
     */
    private Ray constructRefractedRay(Point3D point, Vector v) {
        return new Ray(point, v);
    }

    /**
     * calculate the construct of the refracted ray
     * @param point
     * @param v
     * @param n
     * @return
     */
    private Ray constructReflectedRay(Point3D point, Vector v, Vector n) {
        Vector r = v.subtract(n.scale(2*v.dotProduct(n)));
        return new Ray(point, r);
    }
}

