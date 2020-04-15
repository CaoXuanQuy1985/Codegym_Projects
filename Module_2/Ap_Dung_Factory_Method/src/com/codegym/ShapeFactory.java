package com.codegym;

public class ShapeFactory {
    public Shape createShape(String name) {
        if (name.equals("Circle")) {
            return new Circle();
        } else if (name.equals("Rectangle")) {
            return new Rectangle();
        } else {
            return new Square();
        }
    }
}