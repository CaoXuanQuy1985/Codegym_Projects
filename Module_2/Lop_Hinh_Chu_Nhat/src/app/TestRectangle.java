package app;

public class TestRectangle {
    public static void main(String[] args) {
        Rectangle objRec1 = new Rectangle();

        System.out.println("Area of rectangle1 = " + objRec1.calArea());
        System.out.println("Perimeter of rectangle1 = " + objRec1.calPerimeter());
        System.out.println("Display rectangle1:");
        objRec1.display();
        System.out.println("------------------------------------------------");

        System.out.println("Input the width of objRect2 = ");
        float width = Rectangle.getInput();
        System.out.println("Input the height of objRect2 = ");
        float height = Rectangle.getInput();

        Rectangle objRect2 = new Rectangle(width, height);
        System.out.println("Area of rectangle2 = " + objRect2.calArea());
        System.out.println("Perimeter of rectangle2 = " + objRect2.calPerimeter());
        System.out.println("Display rectangle2:");
        objRect2.display();
    }
}