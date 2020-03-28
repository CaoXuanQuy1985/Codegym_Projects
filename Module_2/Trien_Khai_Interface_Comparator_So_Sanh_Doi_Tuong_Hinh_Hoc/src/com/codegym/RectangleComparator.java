package com.codegym;
import java.util.Comparator;

class RectangleComparator implements Comparator<Rectangle> {
    public int compare(Rectangle obj1, Rectangle obj2) {
        return (obj1.getArea() < obj2.getArea()) ? -1 : ((obj1.getArea() == obj2.getArea()) ? 0 : 1);
    }
}