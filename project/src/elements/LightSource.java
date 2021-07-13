package elements;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * interface for all light source
 */
public interface LightSource {
    /**
     * get the color of the intensity
     * @param p Point3D
     * @return the intensity of the light
     */
    public Color getIntensity(Point3D p);

    /**
     * get the vector normalized
     * @param p Point3D
     * @return the vector normalized
     */
    public Vector getL(Point3D p);

    /**
     * get the distance of the light
     * @param point Point3D
     * @return the distance of the light
     */
    public double getDistance(Point3D point);
}
