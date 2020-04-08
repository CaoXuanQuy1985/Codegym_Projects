package com.codegym;

public class BinarySearchTest {
    public static void main(String[] args) {
        Integer[] arraySource = {2, 4, 7, 10, 11, 45, 50, 59, 60, 66, 69, 70, 79};

        BinarySearchWithoutRecursion bswr = new BinarySearchWithoutRecursion();
        Integer itemToFind = 66;
        Integer indexFound = bswr.binarySearch(arraySource, itemToFind);
        if (indexFound != null) {
            System.out.println("Đã tìm thấy phần tử: " + itemToFind + " tại vị trí index = " + indexFound);
        } else {
            System.out.println("Không tìm thấy phần tử: " + itemToFind + " trong mảng");
        }

        Integer itemToFind2 = 100;
        Integer indexFound2 = bswr.binarySearch(arraySource, itemToFind2);
        if (indexFound2 != null) {
            System.out.println("Đã tìm thấy phần tử: " + itemToFind2 + " tại vị trí index = " + indexFound2);
        } else {
            System.out.println("Không tìm thấy phần tử: " + itemToFind2 + " trong mảng");
        }
    }
}