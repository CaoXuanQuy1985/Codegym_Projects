package com.codegym;
import java.util.Random;

public class TestingSystem {
    private static Random rand = new Random(100);
    public static void main(String[] args) {
        Shape[] shapes = new Shape[4];

        System.out.println("Hãy nhập chiều dài cạnh hình vuông:");
        double size = Shape.user.getInput();
        shapes[0] = new Square(size);

        System.out.println("Hãy nhập chiều dài hình chữ nhật:");
        double height = Shape.user.getInput();
        System.out.println("Hãy nhập chiều rộng hình chữ nhật:");
        double width = Shape.user.getInput();
        shapes[1] = new Rectangle(width, height);

        shapes[2] = new Circle();
        shapes[3] = new Triangle();

        for(Shape shape : shapes) {
            if(shape instanceof Colorable){
                ((Colorable)shape).howToColor();
            }
            System.out.println(shape);
        }        
    }
}