package com.codegym;

public class SelectionSort {
    public int[] selectionSort(int[] list) {
        for (int outer = 0; outer < list.length; outer++) {
            int maxIndex = outer;
            for (int inner = outer + 1; inner < list.length; inner++) {
                if (list[maxIndex] < list[inner]) {
                    maxIndex = inner;
                }
            }
            int temp = list[maxIndex];
            list[maxIndex] = list[outer];
            list[outer] = temp;
        }

        return list;
    }

    public void showList(int[] list) {
        for (int number : list) {
            System.out.print(number + " ");   
        }
        System.out.println();
    }
}