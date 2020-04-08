package com.codegym;

public class BubbleSortTest {
    public static void main(String[] args) {
        int[] array = {5,2,1,8,24,27,54,34,12,13,14,90};

        BubbleSort bs = new BubbleSort();
        bs.bubleSort(array);

        bs.displaySortedArray(array);
    }
}