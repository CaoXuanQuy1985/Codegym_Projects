package com.codegym;

import java.util.*;

public class StudentsDatabaseClient {
    public static void main(String[] args) {
        Student st1 = new AscendingStudent("Cao Xuan Quy", 35);
        Student st2 = new AscendingStudent("Hoang Minh Giam", 30);
        Student st3 = new AscendingStudent("Tran Hung Dao", 25);
        Student st4 = new AscendingStudent("Tran Minh Chien", 42);
        Student st5 = new AscendingStudent("Le Huynh Duc", 50);
        Student st6 = new AscendingStudent("Nguyen Hong Son", 52);

        StudentsDatabase database = new StudentsDatabase();

        database.addStudent(st1);
        database.addStudent(st2);
        database.addStudent(st3);

        database.showStudents();

        Map<String, Integer> treeMap = new TreeMap<>();
        treeMap.put(st4.getName(), st4.getAge());
        treeMap.put(st5.getName(), st5.getAge());
        treeMap.put(st6.getName(), st6.getAge());

        database.addAll(treeMap);

        database.showStudents();

        System.out.println("Sắp xếp theo thứ tự tăng dần: ");
        database.sortDatabase();
        System.out.println("Sắp xếp theo thứ tự giảm dần: ");

        Student st7 = new DecesdingStudent("Cao Xuan Quy", 35);
        Student st8 = new DecesdingStudent("Hoang Minh Giam", 30);
        Student st9 = new DecesdingStudent("Tran Hung Dao", 25);
        Student st10 = new DecesdingStudent("Tran Minh Chien", 42);
        Student st11 = new DecesdingStudent("Le Huynh Duc", 50);
        Student st12 = new DecesdingStudent("Nguyen Hong Son", 52);

        database.addStudent(st7);
        database.addStudent(st8);
        database.addStudent(st9);
        database.addStudent(st10);
        database.addStudent(st11);
        database.addStudent(st12);

        database.sortDatabase();

        System.out.println("Sắp xếp theo thứ tự giảm dần: ");
        database.sortReverseStudent();
    }
}