package com.codegym;

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
        super();
        this.width = 2.0;
        this.height = 1.0;
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public double getWidth() {
        return this.width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getHeight() {
        return this.height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public void draw(){
        System.out.println("Drawing rectangle");
    }

    public void erase() {
        System.out.println("Erasing the rectangle");
    }

    public void resize(double percent) {
        this.width += percent * this.width / 100;
        this.height += percent * this.height / 100;
    }

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width + this.height);
    }

    public String toString() {
        return "Rectangle with width = " + this.width + ", height = " + this.height + ", area = " + this.getArea();
    }
}