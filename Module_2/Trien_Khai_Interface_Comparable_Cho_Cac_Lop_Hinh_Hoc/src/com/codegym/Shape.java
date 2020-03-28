package com.codegym;
import java.lang.Comparable;

abstract class Shape implements Comparable<Shape> {
    protected int xPos;
    protected int yPos;
    protected static User user = new User();

    public Shape() {
        this.xPos = 0;
        this.yPos = 0;
    }

    public Shape(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public abstract void draw();
    public abstract void erase();
    public abstract double getArea();

    public void moveTo(int xPos, int yPos) {
        this.erase();
        this.xPos += xPos;
        this.yPos += yPos;
        this.draw(); 
    }

    public int compareTo(Shape shape) {
        double thisArea = this.getArea();
        double argArea = shape.getArea();
        
        return (thisArea < argArea) ? (-1) : ((thisArea == argArea) ? 0 : 1);
    }

    public String toString() {
        return "Shape has cordinate {" + this.xPos + ", " + this.yPos + "}";
    }
}