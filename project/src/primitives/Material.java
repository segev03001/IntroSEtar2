package primitives;

public class Material {
    public double Kd = 0, Ks = 0;
    public int nShininess = 0;

    public Material setKd(double kd) {
        this.Kd = kd;
        return this;
    }

    public Material setkS(double kS) {
        this.Ks = kS;
        return this;
    }

    public Material setShininess(int nShininess) {
        this.nShininess = nShininess;
        return this;
    }

    public double getKd() {
        return Kd;
    }

    public double getkS() {
        return Ks;
    }

    public int getnShininess() {
        return nShininess;
    }
}
