package com.codegym;

public abstract class AbstractData<T> {
    int key;
    T leftChild;
    T rightChild;

    public AbstractData(int key) {
        this.key = key;
        this.leftChild = null;
        this.rightChild = null;
    }

    public abstract String toString();
}