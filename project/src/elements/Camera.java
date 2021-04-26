package elements;

import Primitives.Point3D;
import Primitives.Ray;
import Primitives.Vector;

import static Primitives.Util.isZero;

public class Camera {
    final private Point3D p0;
    final private Vector vUP;
    final private Vector vTO;
    final private Vector vRIGhT;
    private double width;
    private double height;
    private double distance;

    public Camera(Point3D p0, Vector vTO, Vector vUP) {
        if (!isZero(vUP.dotProduct(vTO))) {
            throw new IllegalArgumentException("up vector and to vector aren't orthogonal");
        }
        this.p0 = p0;
        this.vUP = vUP.normalized();
        this.vTO = vTO.normalized();

        this.vRIGhT = this.vTO.crossProduct(vUP);
    }

    public Point3D getP0() {
        return p0;
    }

    public Vector getvUP() {
        return vUP;
    }

    public Vector getvTO() {
        return vTO;
    }

    public Vector getvRIGhT() {
        return vRIGhT;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public double getDistance() {
        return distance;
    }

    //chaining methods
    public Camera setViewPlaneSize(double width, double height) {
        this.height = height;
        this.width = width;
        return this;
    }

    public Camera setWidth(double width) {
        this.width = width;
        return this;
    }

    public Camera setHeight(double height) {
        this.height = height;
        return this;
    }

    public Camera setDistance(double distance) {
        this.distance = distance;
        return this;
    }

    /**
     * @param nX
     * @param nY
     * @param j
     * @param i
     * @return
     */
    public Ray constructRayThroughPixel(int nX, int nY, int j, int i) {
        Point3D Pc = p0.add(vTO.scale(distance));
        double Rx = width / nX;
        double Ry = height / nY;

        Point3D Pij = Pc;
        double Yi = -(i - (nY - 1) / 2d)*Ry;
        double Xj = (j - (nX - 1) / 2d)*Rx;

        if (!isZero(Xj)) {
            Pij = Pij.add(vRIGhT.scale(Xj));
        }
        if (!isZero(Yi)) {
            Pij = Pij.add(vUP.scale(Yi));
        }
        Vector Vij = Pij.subtract(p0);
        return new Ray(p0, Vij);
    }
}
