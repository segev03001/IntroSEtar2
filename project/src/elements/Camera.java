package elements;

import primitives.Point3D;
import primitives.Ray;
import primitives.Vector;

import java.util.ArrayList;
import java.util.List;

import static primitives.Util.isZero;

public class Camera {
    final private Point3D p0;
    final private Vector vUP;
    final private Vector vTO;
    final private Vector vRIGhT;
    private double width;
    private double height;
    private double distance;

    /**
     * constructor
     *
     * @param p0  Point3D
     * @param vTO Vector
     * @param vUP Vector
     */
    public Camera(Point3D p0, Vector vTO, Vector vUP) {
        if (!isZero(vUP.dotProduct(vTO))) {
            throw new IllegalArgumentException("up vector and to vector aren't orthogonal");
        }
        this.p0 = p0;
        this.vUP = vUP.normalized();
        this.vTO = vTO.normalized();

        this.vRIGhT = this.vTO.crossProduct(vUP);
    }

    /**
     * get Point3D
     *
     * @return p0 Point3D
     */
    public Point3D getP0() {
        return p0;
    }

    /**
     * get Vector
     *
     * @return vUP Vector
     */
    public Vector getvUP() {
        return vUP;
    }

    /**
     * get Vector
     *
     * @return vTO Vector
     */
    public Vector getvTO() {
        return vTO;
    }

    /**
     * get Vector
     *
     * @return vRIGhT Vector
     */
    public Vector getvRIGhT() {
        return vRIGhT;
    }

    /**
     * get Vector
     *
     * @return width Vector
     */
    public double getWidth() {
        return width;
    }

    /**
     * get double
     *
     * @return height Vector
     */
    public double getHeight() {
        return height;
    }

    /**
     * get double
     *
     * @return distance Vector
     */
    public double getDistance() {
        return distance;
    }

    /**
     * Update method for the View Plane size, which receives two numbers - width
     * and height (in this order) and returns the camera object itself
     *
     * @param width  the width
     * @param height the height
     * @return the camera object itself
     */
    public Camera setViewPlaneSize(double width, double height) {
        this.height = height;
        this.width = width;
        return this;
    }

    /**
     * set Width
     *
     * @param width
     * @return the same object
     */
    public Camera setWidth(double width) {
        this.width = width;
        return this;
    }

    /**
     * set Height
     *
     * @param height
     * @return the same object
     */
    public Camera setHeight(double height) {
        this.height = height;
        return this;
    }

    /**
     * set Distance
     *
     * @param distance
     * @return the same object
     */
    public Camera setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    /**
     * Constructs the beam that passes through the pixel
     *
     * @param nX number of pixel in The y-axis
     * @param nY number of pixel in The x-axis
     * @param j  Number of pixels
     * @param i  Number of pixels
     * @return The beam passing through the center of the pixel
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i) {
        Point3D Pc = p0.add(vTO.scale(distance));
        double Rx = width / nX;
        double Ry = height / nY;

        Point3D Pij = Pc;
        double Yi = -(i - (nY - 1) / 2d) * Ry;
        double Xj = (j - (nX - 1) / 2d) * Rx;

        if (!isZero(Xj)) {
            Pij = Pij.add(vRIGhT.scale(Xj));
        }
        if (!isZero(Yi)) {
            Pij = Pij.add(vUP.scale(Yi));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(p0, Vij);
    }

    public Ray constructRayThroughPixelRand(int nX, int nY, double j, double i) {
        Point3D Pc = p0.add(vTO.scale(distance));
        double Rx = width / nX;
        double Ry = height / nY;

        Point3D Pij = Pc;
        double Yi = -(i - (nY - 1) / 2d) * Ry;
        double Xj = (j - (nX - 1) / 2d) * Rx;

        if (!isZero(Xj)) {
            Pij = Pij.add(vRIGhT.scale(Xj));
        }
        if (!isZero(Yi)) {
            Pij = Pij.add(vUP.scale(Yi));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(p0, Vij);
    }

    public List<Ray> constMultipleRays(int nX, int nY, int j, int i, int size) {
        List<Ray> r = new ArrayList<Ray>();
        List<Ray> rays = new ArrayList<Ray>();
        for (int k = 0; k < size; k++) {
            for (int l = 0; l < size; l++) {
                rays.clear();
                rays.add(constructRayThroughPixelRand(nX, nY, j + (double) k / size, i + (double) l / size));
                rays.add(constructRayThroughPixelRand(nX, nY, j + (double) k / size, i - (double) l / size));
                rays.add(constructRayThroughPixelRand(nX, nY, j - (double) k / size, i + (double) l / size));
                rays.add(constructRayThroughPixelRand(nX, nY, j - (double) k / size, i - (double) l / size));
                r.addAll(rays);
            }
        }
        return r;
    }
}
