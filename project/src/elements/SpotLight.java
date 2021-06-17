package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class SpotLight extends PointLight{
    private final Vector direction;

    SpotLight(Color intensity, Point3D position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalized();
    }

    @Override
    public Color getIntensity(Point3D p) {
        double cosTetha = this.direction.dotProduct(getL(p));
        Color intensity =  super.getIntensity(p);
        return intensity.scale(Math.max(0, cosTetha));
    }
}
