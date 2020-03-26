package com.codegym;

public class ObjectSpace {
    public static void main(String[] args) {
        Circle circle = new Circle(2, 3, 5);
        System.out.println(circle);
        Circle cylinder = new Cylinder();
        System.out.println(cylinder);
        Cylinder cylinder2 = new Cylinder(7, 10, 6, 3);
        System.out.println(cylinder2);
        //Cylinder cylinder3 = (Cylinder)new Circle();

        System.out.println(circle.getArea());
        System.out.println(circle.getPerimeter());
        System.out.println(circle.getVolume());

        System.out.println(cylinder2.getArea());
        System.out.println(cylinder2.getPerimeter());
        System.out.println(cylinder2.getVolume());
    }
}