public class Cuboid extends Shape3D {
    protected final double height;
    protected final double width;
    protected final double length;

    /**
    Creates a Cuboid.
    */
    public Cuboid(double height, double width, double length) {
        this.height = height;
        this.width = width;
        this.length = length;
    }

    /**
    Returns string representation of a cuboid.
    */
    public String toString() {
        return "Cuboid [" + String.format("%.2f", this.height) + " x " +
                            String.format("%.2f", this.width) + " x " + 
                            String.format("%.2f", this.length) + "]";
    }

    protected double getVolume() {
        double vol = this.height * this.width * this.length;
        return vol;
    }

    protected double getSurfaceArea() {
        double area = (2 * this.length * this.width) +
                      (2 * this.length * this.height) +
                      (2 * this.width * this.height);
        return area;
    }

    public Cuboid setHeight(double x) {
        return new Cuboid(x, this.width, this.length);
    }

    public Cuboid setWidth(double x) {
        return new Cuboid(this.height, x, this.length);
    }
        
    public Cuboid setLength(double x) {
        return new Cuboid(this.height, this.width, x);
    }
}

