package com.codegym;
import java.lang.Math;

class Circle extends Shape {
    private double radius;
    private static final double PI = 3.14;

    public Circle(){
        super();
        this.radius = 2.0;
    }
    public Circle(double radius) {
        super();
        this.radius = radius;
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void draw() {
        System.out.println("Drawing the Circle");
    }
    public void erase() {
        System.out.println("Erasing the Circle");
    }
    public void resize(double percent) {
        this.radius += percent * this.radius / 100;
    }
    @Override
    public double getArea() {
        return Math.pow(this.radius, 2) * PI;
    }
    public double getPerimeter() {
        return 2 * this.radius * PI;
    }

    public String toString() {
        return "The Circle with radius = " + this.radius + " area = " + this.getArea();
    }
}