package com.codegym;

public class BinarySearchApp {
    public static void main(String[] args) {
        BinarySearch<Integer> bs = new BinarySearch<>(Integer.class, 1000);
        Integer[] arrInt = bs.getArrayGeneric();

        for (int i = 0; i < arrInt.length; i++) {
            arrInt[i] = i + 1;
        }

        bs.searchBinary(277, 0, arrInt.length - 1);
        bs.searchBinary(945, 0, arrInt.length - 1);
        bs.searchBinary(78, 0, arrInt.length - 1);
        bs.searchBinary(2770, 0, arrInt.length - 1);
    }
}