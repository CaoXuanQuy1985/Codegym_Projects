package com.codegym;

public class InsertionSortTest {
    public static void main(String[] args) {
        int[] array = {9, 4, 3, 7, 5, 12, 45, 89, 54, 65, 70};
        InsertionSort is = new InsertionSort();
        is.insertionSort(array);

        is.displaySortedArray(array);

        int[] array2 = new int[100];
        for (int i = 0; i < 100; i++) {
            array2[i] = i + 1;
        }

        is.insertionSort(array2);

        is.displaySortedArray(array2);
    }
}