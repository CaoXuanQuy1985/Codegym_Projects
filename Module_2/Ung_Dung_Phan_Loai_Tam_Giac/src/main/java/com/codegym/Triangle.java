package com.codegym;

class Triangle {
    private double size1;
    private double size2;
    private double size3;

    public Triangle() {
        this.size1 = 2;
        this.size2 = 5;
        this.size3 = 4;
    }

    public Triangle(double size1, double size2, double size3) {
        this.size1 = size1;
        this.size2 = size2;
        this.size3 = size3;
    }

    public double getSize1() {
        return this.size1;
    }

    public void setSize1(double size1) {
        this.size1 = size1;
    }

    public double getSize2() {
        return this.size1;
    }

    public void setSize2(double size2) {
        this.size2 = size2;
    }

    public double getSize3() {
        return this.size1;
    }

    public void setSize3(double size3) {
        this.size3 = size3;
    }
}