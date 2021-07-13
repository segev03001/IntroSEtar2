package geometries;

/**
 * abstract class for RadialGeometry
 */
public abstract class RadialGeometry {
    final protected double radius;

    /**
     * basic constructor
     * @param radius for radios
     */
    public RadialGeometry(double radius) {
        this.radius = radius;
    }

    /**
     * get the radios
     * @return the radios
     */
    public double getRadios() {
        return radius;
    }
}
