package com.lakshman.maven.threedimensionalshapes;

public class Cube {
    private double side;

    public Cube(double side) {
        this.side = side;
    }

    public double getVolume() {
        return side * side * side;
    }

    public double getSurfaceArea() {
        return 6 * side * side;
    }
}
