package com.codegym;
import java.lang.reflect.*;
import java.util.*;

public class MyArrayList<T> {
    private static final int INITIAL_CAPACITY = 10;
    private int currentCapacity;
    private int size = 0;
    private T[] underArray;

    @SuppressWarnings("unchecked")
    private T[] initialArrayGeneric(Class<T> type, int capacity) {
        this.underArray = (T[]) Array.newInstance(type, capacity);
        this.currentCapacity = INITIAL_CAPACITY;

        return this.underArray;
    }

    public MyArrayList(Class<T> type) {
        initialArrayGeneric(type, INITIAL_CAPACITY);
    }

    private boolean checkArrayFull() {
        return (this.size == this.currentCapacity) ? true : false;
    }

    private T[] incrementCapacity(Class<T> type) {
        T[] newUnderArray = Arrays.copyOf(this.underArray, currentCapacity + INITIAL_CAPACITY);
        this.currentCapacity += INITIAL_CAPACITY;
        return newUnderArray;
    }

    public T get(int index) {
        if (index >= this.underArray.length || index < 0) {
            throw new IndexOutOfBoundsException("Chỉ số index bạn nhập vào không hợp le");
        } 
        return this.underArray[index];
    }

    public void add(T elem, Class<T> type) {
        if (checkArrayFull()) {
            this.underArray = incrementCapacity(type);
        }
        this.underArray[size++] = elem;
    }

    public void displayArrayList() {
        System.out.print("[");
        for (int i = 0; i < this.underArray.length; i++) {
            if (this.underArray[i] == null) {
                break;
            } else {
                if (i < (this.underArray.length - 1) && this.underArray[i + 1] == null) {
                    System.out.print(this.underArray[i]);
                    break;
                }
                System.out.print(this.underArray[i] + ", ");
            }
        }
        System.out.println("]");
    }
}