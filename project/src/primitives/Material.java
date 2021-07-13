package primitives;

/**
 * class for the material of the object
 */
public class Material {
    public double Kd = 0, Ks = 0;
    public int nShininess = 0;
    public double kr =0;
    public double kt = 0;

    /**
     * set the parameter kd of the material
     * @param kd for this.Kd
     * @returnthe object itself
     * for caning
     */
    public Material setKd(double kd) {
        this.Kd = kd;
        return this;
    }

    /**
     * set the parameter kd of the material
     * @param kS for this.kS
     * @returnthe object itself
     * for caning
     */
    public Material setkS(double kS) {
        this.Ks = kS;
        return this;
    }

    /**
     * set the parameter Shininess of the material
     * @param nShininess for this.Shininess
     * @returnthe object itself
     * for caning
     */
    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    /**
     * get Kd
     * @return Kd
     */
    public double getKd() {
        return Kd;
    }

    /**
     * get Ks
     * @return Ks
     */
    public double getkS() {
        return Ks;
    }

    /**
     * get nShininess
     * @return nShininess
     */
    public int getnShininess() {
        return nShininess;
    }
}
