package com.codegym;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        for (int outer = 1; outer < array.length; outer++) {
            int temp = array[outer];
            for (int inner = outer; inner > 0; inner--) {
                if ((array[inner - 1] > temp) && (inner >= 1)) {
                    int swap = array[inner];
                    array[inner] = array[inner - 1];
                    array[inner - 1] = swap;
                } else {
                    array[inner] = temp;
                    break;
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