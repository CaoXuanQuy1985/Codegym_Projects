package com.codegym;

class Rectangle extends Shape {
    private double width;
    private double height;

    public Rectangle() {
        this.width = 1.0;
        this.height = 1.0;
        System.out.println("Rectangle Constructor default");
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
        System.out.println("Rectangle Constructor with 2 parameters");
    }

    public Rectangle(String color, boolean filled, double width, double height) {
        super(color, filled);
        this.width = width;
        this.height = height;
        System.out.println("Rectangle Constructor with 4 parameters");
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

    public double getArea() {
        return this.width * this.height;
    }

    public double getPerimeter() {
        return (this.width + this.height) * 2;
    }

    public String toString() {
        return "A Rectangle with width = " + this.width + " height = " + this.height + " which is a subClass of Shape " + super.toString();
    }
}