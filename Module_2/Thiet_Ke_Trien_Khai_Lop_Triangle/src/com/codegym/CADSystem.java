package com.codegym;
import com.codegym.shape.*;
import com.codegym.user.*;

public class CADSystem {
    public static void main(String[] args) {
        System.out.println("Nhap mau sac cua tam giac: ");
        String color = User.getInputColor();
        System.out.println("Nhap trang thai mau sac cua tam giac: ");
        boolean filled = User.getInputFilled();
        System.out.println("Nhap size1 cua tam giac: ");
        double size1 = User.getInputSize();
        System.out.println("Nhap size2 cua tam giac: ");
        double size2 = User.getInputSize();
        System.out.println("Nhap size3 cua tam giac: ");
        double size3 = User.getInputSize();

        User user = new User(color, filled, size1, size2, size3);
        Triangle triangle = new Triangle();
        triangle.setUser(user);
        triangle = new Triangle(user);

        System.out.println(triangle);
    }
}