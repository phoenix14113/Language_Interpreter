package edu.wallawalla.cs.cptr354.shape;

public class Rectangle implements Shape {
    double height = 0;
    double width = 0;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return width * 2 + height * 2;
    }
}
