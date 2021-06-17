package elements;

import primitives.Color;

class Light {
    protected final Color intensity;

    Light(Color intensity) {
        this.intensity = intensity;
    }
    public Color getIntensity(){
        return this.intensity;
    }
}
