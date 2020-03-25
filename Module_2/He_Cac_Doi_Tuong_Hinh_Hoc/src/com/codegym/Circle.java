package com.codegym;
import java.lang.Math;

class Circle extends Shape{
    private double radius;
    private static final double PI = 3.14;

    public Circle() {
        this.radius = 1.0;
        System.out.println("Circle Constructor default");
    }

    public Circle(double radius) {
        this.radius = radius;
        System.out.println("CIrcle Constructor with 1 parameters");
    }

    public Circle(String color, boolean filled, double radius) {
        super(color, filled);
        this.color = color;
        this.filled = filled;
        this.radius = radius;
        System.out.println("Circle Constructor with 3 parameters");
    }

    public double getRadius() {
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * PI;
    }

    public double getPerimeter() {
        return (Math.pow(2 * this.radius, 2) * PI) / 4;
    }

    public String toString() {
        return "A Circle with radius = " + this.radius + " which is a subClass of " + super.toString();
    }
}