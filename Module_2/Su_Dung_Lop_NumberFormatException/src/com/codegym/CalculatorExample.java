package com.codegym;

import java.util.Scanner;

public class CalculatorExample {
    private static Scanner sc = new Scanner(System.in);

    public static Integer getValue() {
        if (sc.hasNextInt()) {
            return sc.nextInt();
        }
        System.out.println("Format int is invalid, try again");
        return getValue();
    }

    public static void calculate(int x, int y) {
        int add = x + y;
        int sub = x - y;
        int mul = x * y;
        int div = x / y;

        System.out.println("x + y = " + add);
        System.out.println("x - y = " + sub);
        System.out.println("x * y = " + mul);
        System.out.println("x / y = " + div);
    }
    public static void main(String[] args) {
        System.out.println("Nhap so x:");
        int x = getValue();
        System.out.println("Nhap so y:");
        int y = getValue();

        try {
            calculate(x, y);
        } catch (Exception ex) {
            System.err.println("ex.getMessage(): " + ex.getMessage());
        }
    }
}