package com.codegym;

public class TestStudent {
    public static void main(String[] args) {
        Student.change();

        Student st1 = new Student(111, "Cao"),
                     st2 = new Student(222, "Xuan"),
                     st3 = new Student(333, "Quy");

                     st1.display();
                     st2.display();
                     st3.display();
    }
}