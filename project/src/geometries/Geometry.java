package geometries;

import primitives.Color;
import primitives.Material;
import primitives.Vector;
import primitives.Point3D;

public abstract class Geometry implements Intersectable {
    protected Color emission = Color.BLACK;
    private Material material = new Material();
    /**
     * calculate the normal
     * @param p point
     * @return normal of the geometries
     */
    public abstract Vector getNormal(Point3D p);

    public Color getEmission() {
        return this.emission;
    }

    public Geometry setEmission(Color emission){
        this.emission = emission;
        return this;
    }

    public Material getMaterial() {
        return material;
    }

    public Geometry setMaterial(Material material) {
        this.material = material;
        return this;
    }
}
