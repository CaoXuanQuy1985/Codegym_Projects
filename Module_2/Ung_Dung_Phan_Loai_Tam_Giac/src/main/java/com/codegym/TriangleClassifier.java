package com.codegym;
import java.util.Scanner;

public class TriangleClassifier {
    private static Triangle triangle = new Triangle();
    private static Scanner sc;

    private static final String ISOSCELES = "Isosceles Triangle";
    private static final String EQUILATERAL = "Equilateral Triangle";
    private static final String REGULAR = "Regular Triangle";
    private static final String NOTTRIANGLE = "Is NOT Triangle";

    private boolean isIsosceles(double size1, double size2, double size3) {
        return (size1 == size2) || (size1 == size3) || (size2 == size3) ? true : false;
    }

    private boolean isEquilateral(double size1, double size2, double size3) {
        return (size1 == size2) && (size2 == size3) ? true : false;
    }

    private boolean isRegular(double size1, double size2, double size3) {
        return (size1 + size2 > size3) && (size1 + size3 > size2) && (size2 + size3 > size1) ? true : false;
    }

    public String checkTypeTriangle(double size1, double size2, double size3) {
        // Sprint 1: throw new UnsupportedOperationException("This operator is not supported");


        String result = REGULAR;
        if (isRegular(size1, size2, size3)) {
            if (isIsosceles(size1, size2, size3))
                result = ISOSCELES;
            if (isEquilateral(size1, size2, size3)) {
                result = EQUILATERAL;
            }
        } else {
            result = NOTTRIANGLE;
        }

        return result;
    }

    public double getInputSize() {
        sc = new Scanner(System.in);
        if (sc.hasNextDouble()) {
            return sc.nextDouble();
        }

        System.out.println("Invalid format double, try again");
        return getInputSize();
    }
}