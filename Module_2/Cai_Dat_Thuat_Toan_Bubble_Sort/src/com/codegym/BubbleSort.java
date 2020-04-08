package com.codegym;

public class BubbleSort {
    public int[] bubleSort(int[] array) {
        for (int outer = array.length - 1; outer >= 0; outer--) {
            for (int inner = 0; inner < outer; inner++) {
                if (array[inner] > array[inner + 1]) {
                    int swap = array[inner + 1];
                    array[inner + 1] = array[inner];
                    array[inner] = swap;
                }
            }
        }

        return array;
    }

    public void displaySortedArray(int[] array) {
        for (int item : array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}