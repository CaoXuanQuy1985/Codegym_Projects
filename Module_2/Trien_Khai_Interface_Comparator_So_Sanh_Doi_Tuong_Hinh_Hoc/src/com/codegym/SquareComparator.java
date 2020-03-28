package com.codegym;
import java.util.Comparator;

class SquareComparator implements Comparator<Square> {
    public int compare(Square obj1, Square obj2) {
        return (obj1.getArea() < obj2.getArea()) ? -1 : ((obj1.getArea() == obj2.getArea()) ? 0 : 1);
    }
}