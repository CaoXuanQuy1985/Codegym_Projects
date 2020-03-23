package app;
import java.util.Scanner;

public class Rectangle {
    private static Scanner sc;
    private float width;
    private float height;

    public Rectangle() {
        this.width = 30f;
        this.height = 10f;
    }

    public Rectangle(float width, float height) {
        this.width = width;
        this.height = height;
    }

    public static float getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()) {
            return sc.nextFloat();
        }

        System.out.println("This format is not float type, try again !!!");
        return getInput();
    }

    public float calArea(float width, float height) {
        return width * height;
    }

    public float calArea() {
        return this.width * this.height;
    }

    public float calPerimeter(float width, float height) {
        return 2 * (width + height);
    }

    public float calPerimeter() {
        return 2 * (this.width + this.height);
    }

    public void display() {
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if ((i == 0) || (i == this.height - 1)) {
                    System.out.print("* ");
                }else{
                    if (j == 0 || j == this.width - 1) {
                        System.out.print("* ");
                    } else {
                        System.out.print("  ");
                    }
                }
            }
            System.out.println();
        }
    }
}