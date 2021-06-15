package elements;


import Primitives.Color;

public class AmbientLight {
    private final Color intesity;

    public AmbientLight() {
        this.intesity = Color.BLACK;
    }

    public AmbientLight(Color iA, double kA){
        this.intesity = iA.scale(kA);
    }

    public Color getIntesity(){
        return this.intesity;
    }
}
