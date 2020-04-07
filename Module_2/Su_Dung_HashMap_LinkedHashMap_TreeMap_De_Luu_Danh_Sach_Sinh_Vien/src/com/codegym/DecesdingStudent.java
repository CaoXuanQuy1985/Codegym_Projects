package com.codegym;

public class DecesdingStudent extends Student {
    public DecesdingStudent(String name, int age) {
        super(name, age);
    }
    public int compare(Student std1, Student std2) {
        return (std1.name.compareTo(std2.name) > 0) ? -1 : ((std1.name.compareTo(std2.name) == 0) ? 0 : 1);
    }
}