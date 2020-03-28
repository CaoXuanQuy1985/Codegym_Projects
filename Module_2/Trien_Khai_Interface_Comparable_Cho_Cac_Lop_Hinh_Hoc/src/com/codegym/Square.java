package com.codegym;
import java.lang.Math;

class Square extends Shape{
    private double size;

    public Square(){
        super();
        this.size = 5.5;
    }

    public Square(double size) {
        super();
        this.size = size;
    }

    public double getSize() {
        return this.size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public void draw() {
        System.out.println("Drawing the Square");
    }
    public void erase() {
        System.out.println("Erasing the Squre");
    }
    
    @Override
    public double getArea() {
        return Math.pow(this.size, 2);
    }
    public double getPerimeter() {
        return 4 * this.size;
    }
    public String toString() {
        return "The Square with size = " + this.size + " area = " + this.getArea();
    }
}