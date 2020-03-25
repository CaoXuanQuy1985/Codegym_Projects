package com.codegym;

public class CADSystem extends Shape{
    private Circle circle;
    private Rectangle rectangle;
    private Square square;

    private Shape[] shapes = new Shape[9];

    public CADSystem(String color, boolean filled, double radius, double width, double height) {
        super(color, filled);
        for(int i = 0; i < shapes.length; i++) {
            this.circle = new Circle();
            System.out.println(this.circle);
            this.shapes[i++] = this.circle;
            this.circle = new Circle(radius);
            System.out.println(this.circle);
            this.shapes[i++] = this.circle;
            this.circle = new Circle(color, filled, radius);
            System.out.println(this.circle);
            this.shapes[i] = this.circle;
        }
        this.rectangle = new Rectangle();
        System.out.println(this.rectangle);
        this.rectangle = new Rectangle(width, height);
        System.out.println(this.rectangle);
        this.rectangle = new Rectangle(color, filled, width, height);
        System.out.println(this.rectangle);

        this.square = new Square();
        System.out.println(this.square);
        this.square = new Square(width);
        System.out.println(this.square);
        this.square = new Square(color, filled, width);
        System.out.println(this.square);
    }

    public static void main(String[] args) {
        CADSystem cad = new CADSystem("red", true,4,  7.5, 4.5);
    }
}