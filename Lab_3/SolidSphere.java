class SolidSphere extends Sphere {
    protected final double density;

    /**
    Creates a SolidSphere.
    */
    public SolidSphere(double radius, double density) {
        super(radius);
        this.density = density;
    }

    /**
    Return string representation of SolidSPhere.
    */
    @Override
    public String toString() {
        return "SolidSphere [" + String.format("%.2f", this.radius) + 
               "] with a mass of " + String.format("%.2f", this.getMass());
    }

    protected double getMass() {
        return this.density * this.getVolume();
    }

    protected double getDensity() {
        return this.density;
    }

    public SolidSphere setRadius(double y) {
        return new SolidSphere(y, this.density);
    }
}
    




