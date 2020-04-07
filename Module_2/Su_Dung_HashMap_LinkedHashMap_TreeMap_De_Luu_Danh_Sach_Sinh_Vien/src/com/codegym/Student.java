package com.codegym;

import  java.util.Comparator;

public abstract class Student implements Comparator<Student> {
    protected String name;
    protected int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }

    public abstract int compare(Student std1, Student std2);

    public String toString() {
        return "Student: name = " + this.name + ", age = " + this.age;
    }
}