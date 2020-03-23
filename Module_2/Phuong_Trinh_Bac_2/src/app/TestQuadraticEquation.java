package app;

public class TestQuadraticEquation {
    public static void main(String[] args) {
        QuadraticEquation qe1 = new QuadraticEquation();
        qe1.findVirginity();

        System.out.println("-------------------------------------");

        System.out.println("Nhap he so a: ");
        double a = QuadraticEquation.getInput();
        System.out.println("Nhap he so b: ");
        double b = QuadraticEquation.getInput();
        System.out.println("Nhap he so c: ");
        double c = QuadraticEquation.getInput();
        QuadraticEquation qe2 = new QuadraticEquation(a, b, c);
        qe2.findVirginity();
    }
}