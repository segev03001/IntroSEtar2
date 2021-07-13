package renderer;

import primitives.Color;
import primitives.Ray;
import scene.Scene;

/**
 * abstract class that contain scene
 */
public abstract class BaseRayTracer {

    protected Scene scene;

    /**
     * constructor for BaseRayTracer with scene
     * check that the scene is not null
     * @param scene for scene
     */
    public BaseRayTracer(Scene scene) {
        if(scene == null){
            throw new IllegalArgumentException("scene cannot be null");
        }
        this.scene = scene;
    }

    /**
     * abstract function that get ray and return color
     * @param ray the ray
     * @return the color
     */
    public abstract Color traceRay(Ray ray);

}

