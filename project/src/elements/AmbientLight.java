package elements;
import primitives.Color;
/**
 * class that represents the ambient light in the scene
 */
public class AmbientLight extends Light {
    /**
     * default constructor for ambient light without parameters
     * set the color to black
     */
    public AmbientLight() {
        super(Color.BLACK);
    }

    /**
     * constructor for ambient light with parameters
     * @param iA color of light
     * @param kA Coefficient of attenuation of light
     */
    public AmbientLight(Color iA, double kA){
        super(iA.scale(kA));
    }
}
