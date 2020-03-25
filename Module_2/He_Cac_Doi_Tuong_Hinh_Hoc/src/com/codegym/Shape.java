package com.codegym;

class Shape {
    protected String color;
    protected boolean filled;

    public Shape() {
        this.color = "green";
        this.filled = true;
        System.out.println("Shape Constructor default");
    }

    public Shape(String color, boolean filled) {
        this.color = color;
        this.filled = filled;
        System.out.println("Shape Constructor with parameters");
    }

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return this.filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    public String toString() {
        String filled = (this.filled) ? " is filled" : " is not filled";
        return "Shape with properties: color of " + this.color + " and" + filled;
    }
}