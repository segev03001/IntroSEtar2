package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class DirectionalLight extends Light implements LightSource{

    private final Vector direction;

    DirectionalLight(Color intensity, Vector direction) {
        super(intensity);
        this.direction = direction;
    }

    @Override
    public Color getIntensity(Point3D p) {
        return intensity;
    }

    @Override
    public Vector getL(Point3D p) {
        return this.direction.normalized();
    }
}
