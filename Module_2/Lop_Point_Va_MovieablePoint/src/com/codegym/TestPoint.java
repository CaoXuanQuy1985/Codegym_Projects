package com.codegym;

public class TestPoint {
    public static void main(String[] args) {
        Point point = new Point();
        System.out.println(point);
        Moveable moveP = new Moveable(2, 4);

        for(int i = 0; i < 6; i++) {
            System.out.println(moveP.move());
        }
    }
}