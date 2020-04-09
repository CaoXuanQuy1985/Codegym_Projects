package com.codeggym;

import java.util.*;

public class ArrayIndexOutOfBoundExceptionTest {
    private static int[] array = new int[10];

    public static int[] createRandomArray() {
        Random rand = new Random(47);

        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(47);
        }

        return array;
    }

    public static void main(String[] args) {
        int[] resultArray = createRandomArray();
        try {
            System.out.println("Truy cập đến phần tử có chỉ số index vượt quá kích cỡ mảng sẽ sinh ra biet lệ ArrayIndexOutOfBoundsException");
            int test = resultArray[12];
        } catch (MyArrayIndexOutOfBoundException ex) {
            System.out.println("Caught Exception");
            System.out.println("ex.getMessage(): " + ex.getMessage());
            System.out.println("toString(): " + ex);
            System.out.println("printStackTrace():");
            ex.printStackTrace(System.out);
        }
    }
}