package com.codegym;
import java.lang.Math;

class Circle extends Instance {
    protected static final double PI = 3.14;
    private double xPos;
    private double yPos;
    private double radius;

    public Circle(){
        this.xPos = 0;
        this.yPos = 0;
        this.radius = 5;
        System.out.print("Circle Constructor default");
    }

    public Circle(double xPos, double yPos, double radius) {
        this.xPos = xPos;
        this.yPos = yPos;
        this.radius = radius;
        System.out.println("Circle Constructor with 3 parameters");
    }

    public double getXPos() {
        return this.xPos;
    }

    public void setXPos(double xPos){
        this.xPos = xPos;
    }

    public double getYPos(double yPos){
        return this.yPos;
    }

    public void setYPos(double yPos) {
        this.yPos = yPos;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * PI;
    }
    public double getPerimeter() {
        return 2 * this.radius * PI;
    }
    public double getVolume(){
        throw new UnsupportedOperationException("Circle khong ho tro tinh the tich");
    }
    public void draw() {
        System.out.println("Drawing the Circle");
    }
    public String toString(){
        return "Circle with xPos = " + this.xPos + " yPos = " + this.yPos + " radius = " + this.radius;
    }
}