package elements;

import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

public class PointLight extends Light implements LightSource{

    private final Point3D position;
    private double Kc = 1;
    private double Kl = 0;
    private double Kq = 0;
    PointLight(Color intensity, Point3D position) {
        super(intensity);
        this.position = position;
    }

    public PointLight setKc(double kc) {
        this.Kc = kc;
        return this;
    }

    public PointLight setKl(double kl) {
        this.Kl = kl;
        return this;
    }

    public PointLight setKq(double kq) {
        this.Kq = kq;
        return this;
    }

    @Override
    public Color getIntensity(Point3D p) {
        double d = p.distance(p);
        double attenuation = 1d / (Kc + Kl *d+ Kq *d*d);
        return this.intensity.scale(attenuation);
    }

    @Override
    public Vector getL(Point3D p) {
        return p.subtract(this.position).normalized();
    }


}
