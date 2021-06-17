package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

public abstract class BaseRayTracer {

    protected Scene scene;

    public BaseRayTracer(Scene scene) {
        if(scene == null){
            throw new IllegalArgumentException("scene cannot be null");
        }
        this.scene = scene;
    }

    public abstract Color traceRay(Ray ray);

}

