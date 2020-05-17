class Sphere extends Shape3D {
    protected final double radius;

    /**
    Creates a sphere.
    */
    public Sphere(double radius) {
        this.radius = radius;
    }

    /**
    Returns string representation of a sphere.
    */
    public String toString() {
        return "Sphere [" + String.format("%.2f", this.radius) + "]";
    }

    protected double getVolume() {
        return (4.0 / 3.0) * Math.PI * Math.pow(this.radius, 3);
    }

    protected double getSurfaceArea() {
        return 4 * Math.PI * Math.pow(this.radius, 2);
    }

    public Sphere setRadius(double y) {
        return new Sphere(y);
    }
}

