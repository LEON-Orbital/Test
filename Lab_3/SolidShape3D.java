class SolidShape3D {
    private Shape3D shape;
    private Material material;

    /**
    Creates a SolidShape3D object.
    */
    public SolidShape3D(Shape3D shape, Material material) {
        this.shape = shape;
        this.material = material;
    }

    /**
    String representation of SolidShape 3D object.
    */
    @Override
    public String toString() {
        return "Solid" + shape.toString() + " with a mass of " +
                String.format("%.2f", this.getMass());
    }

    public double getMass() {
        return shape.getVolume() * material.getMatDen();
    }

    public double getDensity() {
        return material.getMatDen();
    }
}


