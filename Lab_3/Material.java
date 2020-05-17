class Material {
    protected final String name;
    protected final double density;

    /**
    Creates a material of given density.
    */
    public Material(String name, double density) {
        this.name = name;
        this.density = density;
    }

    public double getMatDen() {
        return this.density;
    }
}

