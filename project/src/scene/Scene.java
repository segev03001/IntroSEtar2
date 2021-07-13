package scene;

import elements.LightSource;
import primitives.Color;
import elements.AmbientLight;
import geometries.Geometries;
import java.util.LinkedList;
import java.util.List;

/**
 * The scene - contain all the elements in the scene
 */
public class Scene {
    private final String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = new AmbientLight(Color.BLACK, 1.d);
    public Geometries geometries = null;
    public List<LightSource> lights = new LinkedList<>();

    /**
     * basic constructor for scene
     * @param name
     */
    public Scene(String name) {
        this.name = name;
        this.geometries = new Geometries();
    }

    /**
     * set the background
     * @param background
     * @return the object itself
     * chaining methods
     */
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    /**
     * set the ambientLight
     * @param ambientLight
     * @return the object itself
     * chaining methods
     */
    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    /**
     * set the geometries
     * @param geometries
     * @return the object itself
     * chaining methods
     */
    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
