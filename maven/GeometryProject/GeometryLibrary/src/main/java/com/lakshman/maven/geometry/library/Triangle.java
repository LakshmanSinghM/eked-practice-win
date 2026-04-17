package com.lakshman.maven.geometry.library;

public class Triangle {
    private double a, b, c;

    public Triangle(double a, double b, double c) {
        this.a = a; this.b = b; this.c = c;
    }

    public double getArea() {
        double s = (a + b + c) / 2;           // Heron's formula
        return Math.sqrt(s * (s-a) * (s-b) * (s-c));
    }

    public double getPerimeter() {
        return a + b + c;
    }
}
