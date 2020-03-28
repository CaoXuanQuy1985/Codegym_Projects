package com.codegym;
import java.util.*;

public class TestingSystem {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];
        System.out.println("Nhập vào bán kính hình tròn: ");
        double radius = Shape.user.getInput();
        shapes[0] = new Circle(radius);

        System.out.println("Nhập vào chiều rộng hình chữ nhật:");
        double width = Shape.user.getInput();
        System.out.println("Nhập vào chiều dài hình chữ nhật:");
        double height = Shape.user.getInput();
        shapes[1] = new Rectangle(width, height);

        System.out.println("Nhập vào cạnh hình vuông:");
        double size = Shape.user.getInput();
        shapes[2] = new Square(size);

        System.out.println("Nhập vào cạnh a hình tam giác:");
        double a = Shape.user.getInput();
        System.out.println("Nhập vào cạnh b hình tam giác:");
        double b = Shape.user.getInput();
        System.out.println("Nhập vào cạnh c hình tam giác:");
        double c = Shape.user.getInput();
        shapes[3] = new Triangle(a, b, c);

        System.out.println("Trước khi sắp xếp các đối tượng trong mảng:");
        for (Shape shape : shapes) {
            System.out.println(shape);
        }

        Arrays.sort(shapes);
        System.out.println("Sau khi sắp xếp các đối tượng trong mảng:");
        System.out.println("Sử dung Comparable interface so sánh các Shape object trong mảng dựa vào diện tích");
        System.out.println("Quan sát kết quả đầu ra thây các đối tuong trong mảng đã được sắp xếp theo diện tích tăng dần");

        for (Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}