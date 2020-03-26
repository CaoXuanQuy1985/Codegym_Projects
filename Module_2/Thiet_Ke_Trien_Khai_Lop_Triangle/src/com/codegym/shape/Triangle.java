package com.codegym.shape;
import java.lang.Math;
import com.codegym.user.User;

public class Triangle extends Shape{
    private double size1;
    private double size2;
    private double size3;
    private User user;

    public Triangle() {
        this.size1 = 1.0;
        this.size2 = 1.0;
        this.size3 = 1.0;
    }

    public Triangle(User user) {
        super(user.getColorInput(), user.getFilled());
        this.size1 = user.getSize1();
        this.size2 = user.getSize2();
        this.size3 = user.getSize3();
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getSize1() {
        return this.size1;
    }

    public double getSize2() {
        return this.size2;
    }

    public double getSize3() {
        return this.size3;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }

    public double getArea() {
        double area = 0;
        double p = this.getPerimeter() / 2;

        area = Math.sqrt(p * (p - this.size1) * (p - this.size2) * (p - this.size3));
        return area;
    }

    public double getPerimeter() {
        return (this.size1 + this.size2 + this.size3);
    }

    public String toString() {
        return "Triangle that you have just input with color: " + this.getColor() + " filled: " + this.isFilled() + 
                  " Size1 = " + this.size1 + " Size2 = " + size2 + " Size3 = " + size3 + 
                  " Area = " + getArea() + " Perimeters = " + getPerimeter();
    }
}