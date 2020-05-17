public class SolidCuboid extends Cuboid {
    protected final double density;

    /**
    Creates a SolidCuboid.
    */
    public SolidCuboid(double height, double width, double length, double density) {
        super(height, width, length);
        this.density = density;
    }

    /**
    Return string representation of a solidcuboid.
    */
    @Override
    public String toString() {
        return "SolidCuboid [" + String.format("%.2f", this.height) + " x " +
                                 String.format("%.2f", this.width) + " x " + 
                                 String.format("%.2f", this.length) + "]" +
                                 " with a mass of " + String.format("%.2f", this.getMass());
    }

    protected double getMass() {
        return this.getVolume() * this.density;
    }


    protected double getDensity() {
        return this.density;
    }

    public SolidCuboid setHeight(double x) {
        return new SolidCuboid(x, this.width, this.length, this.density);
    }

    public SolidCuboid setWidth(double x) {
        return new SolidCuboid(this.height, x, this.length, this.density);
    }
            
    public SolidCuboid setLength(double x) {
        return new SolidCuboid(this.height, this.width, x, this.density);
    }
}
