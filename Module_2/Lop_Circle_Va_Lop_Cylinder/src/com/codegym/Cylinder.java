package com.codegym;
import java.lang.Math;

class Cylinder extends Circle{
    private double height;

    public Cylinder(){
        this.height = 7.5;
        System.out.println("Cylinder Constructor default");
    }

    public Cylinder(double xPos, double yPos, double radius, double height) {
        super(xPos, yPos, radius);
        this.height = height;
        System.out.println("Cylinder constructor with 4 parameters");
    }

    public double getHeight(){
        return this.height;
    }

    public void setHeight(double height){
        this.height = height;
    }

    public double getArea(){
        return 2 * PI * this.getRadius() * (this.getRadius() + this.height);
    }

    public double getVolume(){
        return PI * Math.pow(this.getRadius() , 2) * this.height;
    }

    public String toString() {
        return "A Cylinder with height = " + this.height + " is subClass of Circle: " + super.toString();
    }
}