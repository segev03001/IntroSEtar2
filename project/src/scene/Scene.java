package scene;

import Primitives.Color;
import elements.AmbientLight;
import geometries.Geometries;

public class Scene {
    private final String name;
    public Color background = Color.BLACK;
    public AmbientLight ambientLight = new AmbientLight(new Color(192,192,192), 1.d);
    public Geometries geometries = null;

    public Scene(String name) {
        this.name = name;
        this.geometries = new Geometries();
    }

    //chaining methods
    public Scene setBackground(Color background) {
        this.background = background;
        return this;
    }

    public Scene setAmbientLight(AmbientLight ambientLight) {
        this.ambientLight = ambientLight;
        return this;
    }

    public Scene setGeometries(Geometries geometries) {
        this.geometries = geometries;
        return this;
    }
}
