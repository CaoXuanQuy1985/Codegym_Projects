package com.codegym;

public class BinarySearchWithoutRecursion {
    public Integer binarySearch(Integer[] array, int itemToFind) {
        int head = 0;
        int tail = array.length - 1;
        int middle = 0;

        while (head <= tail) {
            middle = (head + tail) / 2;
            if (array[middle] == itemToFind) {
                return middle;
            } else if (array[middle] > itemToFind) {
                tail = middle - 1;
            } else if (array[middle] < itemToFind) {
                head = middle + 1;
            }
        }

        return null;
    }
}