package elements;
import primitives.Color;

/**
 *  class for light source with the intensity
 */
class Light {
    protected final Color intensity;

    /**
     * basic constructor to set the intensity
     * @param intensity Color
     */
    Light(Color intensity) {
        this.intensity = intensity;
    }

    /**
     * get the intensity
     * @return this.intensity
     */
    public Color getIntensity() {
        return this.intensity;
    }
}
