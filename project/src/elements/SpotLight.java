package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * call for spot light
 * extends PointLight
 */
public class SpotLight extends PointLight{
    private final Vector direction;

    /**
     * basic constructor
     * @param intensity for super
     * @param position for position of the light
     * @param direction for the direction of the light
     */
    public SpotLight(Color intensity, Point3D position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalized();
    }

    /**
     * calculate the color of the intensity 
     * @param p Point3D
     * @return the intensity of the light
     */
    @Override
    public Color getIntensity(Point3D p) {
        double cosTetha = this.direction.dotProduct(getL(p));
        Color intensity =  super.getIntensity(p);
        return intensity.scale(Math.max(0, cosTetha));
    }
}
