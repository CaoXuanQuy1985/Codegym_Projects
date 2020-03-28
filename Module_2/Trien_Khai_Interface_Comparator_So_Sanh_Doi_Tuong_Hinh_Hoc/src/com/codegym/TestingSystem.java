package com.codegym;
import java.util.*;

public class TestingSystem {
    public static void main(String[] args) {
        System.out.println("Testing for CircleComparator:");
        Circle[] circles = new Circle[4];
        double radius;
        for(int i = 0; i < circles.length; i++) {
            System.out.println("Nhập vào bán kính hình tròn circles[" + i + "]" );
            radius = Shape.user.getInput();
            circles[i] = new Circle(radius);
        }

        System.out.println("Trước khi sắp xếp các đối tượng trong mảng:");
        for (Circle circle : circles) {
            System.out.println(circle);
        }

        Arrays.sort(circles, new CircleComparator());
        System.out.println();
        System.out.println("Sau khi sắp xếp các đối tượng trong mảng:");
        System.out.println("Sử dung Comparator interface so sánh các Shape object trong mảng dựa vào diện tích");
        System.out.println("Quan sát kết quả đầu ra thây các đối tuong trong mảng đã được sắp xếp theo diện tích giảm dần");

        for (Circle circle : circles) {
            System.out.println(circle);
        }
    }
}