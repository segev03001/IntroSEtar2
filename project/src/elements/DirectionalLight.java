package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class for directional light
 * extends Light + implements LightSource
 */
public class DirectionalLight extends Light implements LightSource{

    private final Vector direction;

    /**
     * basic constructor
     * @param intensity for super
     * @param direction for Vector direction
     */
    public DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction;
    }

    /**
     * get the color of the intensity
     * @param p point
     * @return intensity
     */
    @Override
    public Color getIntensity(Point3D p) {
        return intensity;
    }

    /**
     * get Vector direction normalized
     * @param p Point3D
     * @return direction after normalized
     */
    @Override
    public Vector getL(Point3D p) {
        return this.direction.normalized();
    }

    /**
     * get distance of the light
     * @param point Point3D
     * @return infinity value
     */
    @Override
    public double getDistance(Point3D point) {
        return Double.POSITIVE_INFINITY;
    }
}
