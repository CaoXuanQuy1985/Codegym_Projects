package com.codegym;

import java.util.Scanner;

public class Triangle {
    private static Scanner sc;

    public Triangle() {
        sc = new Scanner(System.in);
    }

    public double getSize() {
        if (this.sc.hasNextDouble()) {
            return this.sc.nextDouble();
        }

        System.out.println("Format double type of size is invalid. try again !!!");
        return getSize();
    }
    
    public void throwIllegalTriangleException() throws IllegalTriangleException {
        System.out.println("Hay nhap chieu dai canh a: ");
        double sizeA = this.getSize();
        System.out.println("Hay nhap chieu dai canh b: ");
        double sizeB = this.getSize();
        System.out.println("Hay nhap chieu dai canh c: ");
        double sizeC = this.getSize();

        if (sizeA <= 0 || sizeB <= 0 || sizeC <= 0) {
            throw new IllegalTriangleException("Size of triangle less than or equal 0 Exception");
        }
        if (((sizeA + sizeB <= sizeC) || (sizeB + sizeC <= sizeA) || (sizeA + sizeC <= sizeB))) {
            throw new IllegalTriangleException("Sum of 2 size is less than the third size Exception");
        }
    }
    public static void main(String[] args) {
        Triangle triangle = new Triangle();
        try {
        triangle.throwIllegalTriangleException();
        } catch (IllegalTriangleException ex) {
            System.err.println("Caught " + ex);
        }
    }
}