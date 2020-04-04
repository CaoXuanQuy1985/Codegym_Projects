package com.codegym;

import java.lang.reflect.*;

public class MyQueue<T extends AbstractGenericData<T>> {
    private int capacity;
    private Class<T> typeInformation;
    private T[] underArray;
    private int head;
    private int tail;
    private int currentSize;

    public MyQueue(int capacity, Class<T> typeInformation) {
        this.capacity = capacity;
        this.typeInformation = typeInformation;
        this.head = 0;
        this.tail = -1;
        this.underArray = this.createArrayGeneric(capacity);
    }

    @SuppressWarnings("unchecked")
    private T[] createArrayGeneric(int capacity) {
        return (T[]) Array.newInstance(typeInformation, capacity);
    }

    public boolean isQueueFull() {
        return this.currentSize == this.capacity;
    }

    public boolean isEmpty() {
        return this.currentSize == 0;
    }

    public void enQueue(T elem) {
        if (!this.isQueueFull()) {
            if (this.tail == (this.capacity - 1)) {
                this.tail = -1;
            }
            this.underArray[++this.tail] = elem;
            this.currentSize++;
        } else {
            System.err.println("Queue is full, so we can not add more element !!!");
        }
    }

    public T deQueue() {
        if (!this.isEmpty()) {
            if (this.head == this.capacity) {
                this.head = 0;
            }
            T elem = this.underArray[this.head++];
            this.currentSize--;
            return elem;
        } else {
            System.err.println("Queue is Empty, so we can not get more element !!!");
            return null;
        }
    }
}