package com.codegym;

class Square extends Rectangle {
    public Square() {
        System.out.println("Square Constructor default");
    }

    public Square(double size) {
        super(size, size);
        System.out.println("Square Construcotr with 1 parameter");
    }

    public Square(String color, boolean filled, double size) {
        super(color, filled, size, size);
        System.out.println("Square Constructor with 3 parameters");
    }

    public double getSize() {
        return this.getWidth();
    }

    public void setSize(double size) {
        this.setWidth(size);
        this.setHeight(size);
    }

    public void setWidth(double width) {
        this.setSize(width);
    }

    public void setHeight(double height) {
        this.setSize(height);
    }

    public String toString() {
        return "A Square with size = " + this.getSize() + " which is  a subClass of rectangle with " + super.toString();  
    }
}