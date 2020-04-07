package com.codegym;

import java.lang.Comparable;
import java.lang.reflect.Array;

public class BinarySearch<T extends Comparable<T>> {
    private T[] arrayGeneric;
    private Class<T> kind;
    private int middle;

    public T[] getArrayGeneric() {
        return this.arrayGeneric;
    }

    @SuppressWarnings("unchecked")
    public BinarySearch(Class<T> kind, int lengthArray) throws NegativeArraySizeException {
        this.kind = kind;
        this.arrayGeneric = (T[]) Array.newInstance(kind, lengthArray);
    }

    public boolean searchBinary(T itemToFind, int head, int tail) {
        int length = tail + head + 1;
        if (length % 2 == 0) {
            middle = length / 2 - 1;
        } else {
            middle = length / 2;
        }

        if (itemToFind.compareTo(arrayGeneric[middle]) < 0){
            tail = middle - 1;
        } else if (itemToFind.compareTo(arrayGeneric[middle]) > 0) {
            head = middle + 1;
        } else if (itemToFind.compareTo(arrayGeneric[middle]) == 0) {
            System.out.println("Đã tìm thấy phần tử " + itemToFind + " tại vị trí index = " + middle);
            return true;
        }

        if (tail < head){
            System.out.println("Không thể tìm thấy phần tử " + itemToFind);
            return false;
        }
        return searchBinary(itemToFind, head, tail);
    }
}