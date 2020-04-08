package com.codegym;

public class BubbleSort {
    public int[] bubleSort(int[] array) {
        System.out.println("Thuật toán tạo ra biên outer chạy từ cuối mảng vê đến đàu mảng");
        for (int outer = array.length - 1; outer >= 0; outer--) {
            System.out.println("Tại mỗi chỉ số index = " + outer + " thuật toán lại tạo ra biến inner để chạy từ đầu mảng index = 0 đến index = outer");
            System.out.println("outer = " + outer);
            for (int inner = 0; inner < outer; inner++) {
                System.out.println("Tại inner = " + inner);
                if (array[inner] > array[inner + 1]) {
                    System.out.println("Nếu array[index] > aray[index + 1] thì hoán đổi 2 phần tử này với nhau");
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