package com.codegym;

public class Test {
    public static void main(String[] args) {
        ShapeFactory factory = new ShapeFactory();
        System.out.println(factory.createShape("Circle").getName());
        System.out.println(factory.createShape("Rectangle").getName());
        System.out.println(factory.createShape("Square").getName());
    }
}