package com.codegym;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleClassifierTest {
    private static TriangleClassifier triangleClassifier = new TriangleClassifier();

    @Test
    public void checkTypeTriangleTest() {
        double size1 = 3.16;
        double size2 = 2.73;
        double size3 = 1.62;

        String expectedResult = "Regular Triangle";
        String resultActual = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void checkTypeTriangleTest2() {
        double size1 = 3.16;
        double size2 = 1.0;
        double size3 = 1.62;

        String expectedResult = "Regular Triangle";
        String resultActual = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void checkTypeTriangleTest3() {
        double size1 = 3.0;
        double size2 = 3.0;
        double size3 = 2.5;

        String expectedResult = "Isosceles Triangle";
        String resultActual = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void checkTypeTriangleTest4() {
        double size1 = 6.0;
        double size2 = 6.0;
        double size3 = 6.0;

        String expectedResult = "Equilateral Triangle";
        String resultActual = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        assertEquals(expectedResult, resultActual);
    }

    @Test
    public void checkTypeTriangleTest5() {
        double size1 = 5.0;
        double size2 = 2.0;
        double size3 = 1.0;

        String expectedResult = "Is NOT Triangle";
        String resultActual = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        assertEquals(expectedResult, resultActual);
    }

    public static void main(String[] args) {
        System.out.println("Nhap vao size1 = ");
        double size1 = triangleClassifier.getInputSize();
        System.out.println("Nhap vao size2 = ");
        double size2 = triangleClassifier.getInputSize();
        System.out.println("Nhap vao size3 = ");
        double size3 = triangleClassifier.getInputSize();

        String typeTriangle = triangleClassifier.checkTypeTriangle(size1, size2, size3);
        System.out.println(typeTriangle);
    }
}