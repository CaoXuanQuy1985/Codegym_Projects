package com.codegym;

public class InsertionSort {
    public int[] insertionSort(int[] array) {
        System.out.println("Chương trình sẽ dùng thuật toán sắp xếp chèn để sắp xếp mảng: ");
        displaySortedArray(array);
        System.out.println("Thuật toán sử dụng biến outer chay bắt đầu từ chỉ số index = 1 của mảng array cho đến hết mảng");
        for (int outer = 1; outer < array.length; outer++) {
            System.out.println("Và tạo 1 biến temp để luu giữ phần tử mảng có chỉ sô là outer array[" + outer + "] = " + array[outer]);
            int temp = array[outer];
            System.out.println("Với mỗi vòng lặp của outer thuật toán sử dụng biến inner chay bắt đầu từ chỉ số index = outer của mảng array để chạy ngược về chỉ số 0");
            for (int inner = outer; inner > 0; inner--) {
                System.out.println("Biến inner sẽ chạy ngược về index = 0, để kiểm tra phần tử có chỉ số inner - 1 có lơn hơn biến temp hay không");
                System.out.println("Nếu lớn hơn thuật toán sẽ hoán đổi vị trí phần tử có chỉ số inner - 1 với inner");
                if ((array[inner - 1] > temp) && (inner >= 1)) {
                    System.out.println("Vì  array[" + (inner - 1) + "] > temp = " + temp + " en thuật toán sẽ hoán đổi phần tử có chỉ số: array[inner] với array[inner - 1]");
                    int swap = array[inner];
                    array[inner] = array[inner - 1];
                    array[inner - 1] = swap;
                } else {
                    System.out.println("Nếu array[inner - 1] <= array[inner], thì thuật toán sẽ gán biến temp vào phần tu array[inner]");
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