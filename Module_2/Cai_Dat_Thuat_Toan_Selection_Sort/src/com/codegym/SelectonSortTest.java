package com.codegym;

public class SelectonSortTest {
    public static void main(String[] args) {
        int[] list = {5, 7, 2, 9, 1, 10, 12, 23, 89, 54, 31};
        SelectionSort ss = new SelectionSort();
        ss.selectionSort(list);

        ss.showList(list);

        int[] list2 = new int[100];

        for(int i = 0; i < 100; i++) {
            list2[i] = i + 1;
        }
        ss.selectionSort(list2);
        ss.showList(list2);
    }
}