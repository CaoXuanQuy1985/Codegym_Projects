package com.codegym;
import java.util.Comparator;

class TriangleComparator implements Comparator<Triangle> {
    public int compare(Triangle obj1, Triangle obj2) {
        return (obj1.getArea() < obj2.getArea()) ? -1 : ((obj1.getArea() == obj2.getArea()) ? 0 : 1);
    }
}