package geometries;

import primitives.Point3D;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

/**
 * In order to build a scene in the future that consists of several bodies, all the components must be bound together and the collection
 * of bodies that describe the scene must be kept in a body. Also sometimes we would like to own several bodies in a body of bodies for
 * practical, design and performance reasons.
 * We will add a new class Geometries for Egged of Geometric Bodies
 */
public class Geometries implements Intersectable {

    List<Intersectable> intersectables = null; //Private field of object list

    // constructor
    public Geometries() {
        intersectables = new LinkedList<>();
    }

    // constructor
    public Geometries(Intersectable... intersectables) {
        add(intersectables);
    }

    /**
     * gets an Intersectable And adds it to Intersectable That we have in the class
     * @param intersectables intersect points
     */
    public void add(Intersectable... intersectables) {
        if(this.intersectables == null){
            this.intersectables = new LinkedList<>();
        }
        for (Intersectable item : intersectables) {
            this.intersectables.add(item);
        }
    }

    /**
     * Gives all the points where the given ray is intersecting with the object.
     * @param ray A ray to check if is intersecting with the object
     * @param maxDistance the max distance
     * @return the intersections with the object
     */
    @Override
    public List<GeoPoint> findGeoIntersections(Ray ray, double maxDistance) {
        List<GeoPoint> result = null;

        for (Intersectable item : this.intersectables) {
            List<GeoPoint> itemPoints = item.findGeoIntersections(ray, maxDistance);
            if (itemPoints != null) {
                if (result == null)
                    result = new LinkedList<>();
                result.addAll(itemPoints);
            }
        }
        return result;
    }
}
