package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Vector;
import primitives.Point3D;

/**
 * class for each Geometry
 * implements Intersectable
 */
public abstract class Geometry implements Intersectable {
    protected Color emission = Color.BLACK;
    private Material material = new Material();

    /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    public abstract Vector getNormal(Point3D p);

    /**
     * get the emission
     * @return this.emission
     */
    public Color getEmission() {
        return this.emission;
    }

    /**
     * set the emission
     * @param emission for the emission
     * @return the object itself
     * for chaining
     */
    public Geometry setEmission(Color emission){
        this.emission = emission;
        return this;
    }

    /**
     * get the material
     * @return this.material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * set the material
     * @param material for the material
     * @return the object itself
     * for chaining
     */
    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}
