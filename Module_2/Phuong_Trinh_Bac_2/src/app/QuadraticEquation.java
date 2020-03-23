package app;
import java.util.Scanner;
import java.lang.Math;

public class QuadraticEquation {
    private static Scanner sc;
    private double a;
    private double b;
    private double c;

    public QuadraticEquation() {
        this.a = 2;
        this.b = -7;
        this.c = 3;
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public static float getInput() {
        sc = new Scanner(System.in);

        if(sc.hasNextFloat()){
            return sc.nextFloat();
        }

        System.out.println("Float format is invalid, try again");
        return getInput();
    }

    public void findVirginity() {
        if (this.a == 0) {
            if (b == 0 && c == 0) {
                System.out.println("Phuong trinh co vo so nghiem");
            } else if (b == 0 && c != 0) {
                System.out.println("Phuong trinh vo nghiem");
            }
        } else {
            double delta = (this.b * this.b) - (4 * this.a * this.c);
            if (delta < 0) {
                System.out.println("Phuong trinh vo nghiem");
            } else if (delta == 0) {
                System.out.println("Phuong trinh co 1 nghiem duy nhat x1 = x2 = " + (-(this.b) / (2 * this.a)));
            } else {
                double x1 = (-this.b - Math.sqrt(delta)) / (2 * this.a),
                           x2 = (-this.b + Math.sqrt(delta)) / (2 * this.a);

                System.out.println("Phuong trinh co 2 nghiem rieng biet:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            }
        }
    }


}