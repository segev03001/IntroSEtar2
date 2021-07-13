package elements;
import primitives.Color;
import primitives.Point3D;
import primitives.Vector;

/**
 * class for point light
 * extends Light implements LightSource
 */
public class PointLight extends Light implements LightSource{

    private final Point3D position;
    private double Kc = 1;
    private double Kl = 0;
    private double Kq = 0;

    /**
     * basic constructor
     * @param intensity for super
     * @param position for position of the light
     */
    public PointLight(Color intensity, Point3D position) {
        super(intensity);
        this.position = position;
    }

    /**
     * set the kc of the light
     * @param kc
     * @return the object itself
     * for chaining
     */
    public PointLight setKc(double kc) {
        this.Kc = kc;
        return this;
    }

    /**
     * set the kc of the light
     * @param kl
     * @return the object itself
     * for chaining
     */
    public PointLight setKl(double kl) {
        this.Kl = kl;
        return this;
    }

    /**
     * set the kc of the light
     * @param kq
     * @return the object itself
     * for chaining
     */
    public PointLight setKq(double kq) {
        this.Kq = kq;
        return this;
    }

    /**
     * get the color of the intensity calculate by formula
     * @param p Point3D
     * @return the intensity of the light
     */
    @Override
    public Color getIntensity(Point3D p) {
        double d = p.distance(p);
        double attenuation = 1d / (Kc + Kl *d+ Kq *d*d);
        return this.intensity.scale(attenuation);
    }

    /**
     * get the vector between the point and the location of the light normalized
     * @param p Point3D
     * @return the vector between the point and the location of the light normalized
     */
    @Override
    public Vector getL(Point3D p) {
        return p.subtract(this.position).normalized();
    }

    /**
     * get the distance of the light from a point
     * @param point Point3D
     * @return the distance of the light from a point
     */
    @Override
    public double getDistance(Point3D point) {
        return this.position.distance(point);
    }


}
