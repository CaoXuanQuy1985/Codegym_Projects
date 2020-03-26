package com.codegym;

public class Coordinate {
    public static void main(String[] args) {
        Point2D point2D = new Point2D();
        System.out.println("-------------------Point2D constructor default-----------------");
        System.out.println(point2D);

        Point2D point2D_2 = new Point2D(2.5f, 5.5f);
        System.out.println("-------------------Point2D constructor 2 parameters-----------------");
        System.out.println(point2D_2);

        Point3D point3D = new Point3D();
        System.out.println("-------------------Point3D constructor default-----------------");
        System.out.println(point3D);

        Point2D point3D_2 = new Point3D(2.5f, 5.5f, 7.5f);
        System.out.println("-------------------Point3D constructor 3 parameters-----------------");
        System.out.println(point3D_2);
    }
}