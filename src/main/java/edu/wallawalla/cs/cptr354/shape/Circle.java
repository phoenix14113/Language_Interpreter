package edu.wallawalla.cs.cptr354.shape;

public class Circle implements Shape {
    double radius = 0;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.pow(radius, 2) * Math.PI;
    }

    public double perimeter() {
        return 2 * radius * Math.PI;
    }
}
