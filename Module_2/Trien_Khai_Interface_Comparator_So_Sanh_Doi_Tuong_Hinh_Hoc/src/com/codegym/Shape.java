package com.codegym;

abstract class Shape {
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

    public String toString() {
        return "Shape has cordinate {" + this.xPos + ", " + this.yPos + "}";
    }
}