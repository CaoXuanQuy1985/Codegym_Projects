package com.codegym;
import java.util.Scanner;

class User {
    private static Scanner sc;

    public User() {
        sc = new Scanner(System.in);
    }

    public double getInput() {
        if(sc.hasNextDouble()) {
            return sc.nextDouble();
        }

        System.out.println("Invalid format, try again");
        return getInput();
    }
}