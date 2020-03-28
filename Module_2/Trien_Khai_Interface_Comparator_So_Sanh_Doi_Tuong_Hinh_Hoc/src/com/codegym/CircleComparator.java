package com.codegym;
import java.util.Comparator;

class CircleComparator implements Comparator<Circle> {
    public int compare(Circle obj1, Circle obj2) {
        return (obj1.getArea() < obj2.getArea()) ? 1 : ((obj1.getArea() == obj2.getArea()) ? 0 : -1);
    }
}