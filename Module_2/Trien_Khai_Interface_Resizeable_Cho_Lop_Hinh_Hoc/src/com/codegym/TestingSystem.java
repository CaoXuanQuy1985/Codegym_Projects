package com.codegym;
import java.util.Random;

public class TestingSystem {
    private static Random rand = new Random(100);
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];

        System.out.println("Hãy nhập bán kính hình tròn");
        double radius = Shape.user.getInput();
        shapes[0] = new Circle(radius);

        System.out.println("Hãy nhập chiều rộng hình chữ nhật:");
        double width = Shape.user.getInput();
        System.out.println("Hãy nhập chiều cao hình chữ nhật:");
        double height = Shape.user.getInput();
        shapes[1] = new Rectangle(width, height);

        System.out.println("Hãy nhập chiều dài cạnh  hình vuông :");
        double size = Shape.user.getInput();
        shapes[2] = new Square(size);

        System.out.println("Hãy nhập chiều dài cạnh a  hình tam giác :");
        double a = Shape.user.getInput();
        System.out.println("Hãy nhập chiều dài cạnh b  hình tam giác :");
        double b = Shape.user.getInput();
        System.out.println("Hãy nhập chiều dài cạnh c  hình tam giác :");
        double c = Shape.user.getInput();
        shapes[3] = new Triangle(a, b, c);

        System.out.println("Diện tích các hình trước khi thay đổi kích thước");

        for(Shape shape : shapes) {
            System.out.println(shape);
        }
        System.out.println("Thay đổi kich thước các hình 1 cách ngẫu nhiên theo tỷ lệ từ 1 -> 100");

        for(Shape shape : shapes) {
            shape.resize(rand.nextInt(100));
        }

        System.out.println("Sau khi thay đổi kích thước các hình ta có kích thươc mới là:");
        System.out.println("--------------------------------------------------------");
        for(Shape shape : shapes) {
            System.out.println(shape);
        }
    }
}