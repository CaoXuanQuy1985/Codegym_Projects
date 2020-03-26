package com.codegym.user;
import java.util.Scanner;

public class User {
    private static Scanner sc;
    private String colorInput;
    private boolean filledInput;
    private double size1Input;
    private double size2Input;
    private double size3Input;

    public User(String color, boolean filled, double size1, double size2, double size3) {
        this.colorInput = color;
        this.filledInput = filled;
        this.size1Input = size1;
        this.size2Input = size2;
        this.size3Input = size3;
    }

    public static double getInputSize() {
        sc = new Scanner(System.in);

        if(sc.hasNextDouble()) {
            return sc.nextDouble();
        }

        System.out.println("Invalid double format, try again");
        return getInputSize();
    }

    public static String getInputColor() {
        sc = new Scanner(System.in);

        if(sc.hasNextLine()) {
            return sc.nextLine();
        }

        System.out.println("Invalid String format, try again");
        return getInputColor();
    }

    public static boolean getInputFilled() {
        sc = new Scanner(System.in);

        if(sc.hasNextBoolean()) {
            return sc.nextBoolean();
        }

        System.out.println("Invalid Boolean format, try again");
        return getInputFilled();
    }

    public String getColorInput() {
        return this.colorInput;
    }

    public void setColorInput(String color) {
        this.colorInput = color;
    }

    public boolean getFilled() {
        return this.filledInput;
    }

    public void setFilled(boolean filled) {
        this.filledInput = filled;
    }

    public double getSize1() {
        return this.size1Input;
    }

    public void setSize1(double size1) {
        this.size1Input = size1;
    }

    public double getSize2() {
        return this.size2Input;
    }

    public void setSize2(double size2) {
        this.size2Input = size2;
    }

    public double getSize3() {
        return this.size3Input;
    }

    public void setSize3(double size3) {
        this.size3Input = size3;
    }
}