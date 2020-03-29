package com.codegym;

import java.lang.Math;

public class Cylinder {

    private static final double PI = Math.PI;

    public static double getVolume(int radius, int height){
        double baseArea = getBaseArea(radius);
        double perimeter = getPerimeter(radius);
        double volume = perimeter * height + 2 * baseArea;
        return volume;
    }

    private static double getPerimeter(int radius) {
        double perimeter = 2 * PI  * radius;
        return perimeter;
    }

    private static double getBaseArea(int radius) {
        double baseArea = PI * radius * radius;
        return baseArea;
    }
}
