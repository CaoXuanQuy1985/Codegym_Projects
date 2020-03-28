package com.codegym;
import java.lang.Math;

class Triangle extends Shape {
    private double a;
    private double b;
    private double c;

    public Triangle(){
        super();
        this.a = 3.5;
        this.b = 4.5;
        this.c = 5.5;
    }
    public Triangle(double a, double b, double c) {
        super();
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }
    public void setA(double a) {
        this.a = a;
    }
    public double getB() {
        return this.b;
    }
    public void setB(double b) {
        this.b = b;
    }
    public double getC() {
        return this.c;
    }
    public void setC(double c) {
        this.c = c;
    }

    @Override
    public void draw() {
        System.out.println("Drawing the Triangle");
    }
    @Override
    public void erase() {
        System.out.println("Erasing the Triangle");
    }
    @Override
    public double getArea() {
        double p = (this.getPerimeter() / 2);

        return Math.sqrt(Math.abs(p * (p - this.a) * (p - this.b) * (p - this.c)));
    }

    public double getPerimeter() {
        return this.a + this.b + this.c;
    }

    public String toString() {
        return "Triangle with a = " + this.a + ", b = " + this.b + ", c = " + this.c + " p = " + this.getPerimeter() + " area = " + this.getArea();
    }
}