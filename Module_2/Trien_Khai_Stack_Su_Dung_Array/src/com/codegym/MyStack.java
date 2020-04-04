package com.codegym;

import java.lang.reflect.*;

public class MyStack<T extends AbstractGenericData<T>> {
    private Class<T> typeInformation;
    private T[] underArray;
    private int top;
    private int maxSize;

    public MyStack(int maxSize, Class<T> typeInformation) {
        this.typeInformation = typeInformation;
        this.maxSize = maxSize;
        this.top = -1;
        this.underArray = this.createArrayGeneric(maxSize);
    }

    @SuppressWarnings("unchecked")
    private T[] createArrayGeneric(int maxSize) {
        return (T[]) Array.newInstance(typeInformation, maxSize);
    }

    private boolean isEmpty() {
        return (this.top == -1);
    }

    private boolean isFull() {
        return (this.top == this.maxSize - 1);
    }

    public void push(T elem) throws Exception {
        if (isFull()) {
            throw new Exception("Stack đã đầy, chúng ta không thể chèn thêm được phần tử nào nữa !!!");
        } else {
            this.underArray[++this.top] = elem;
        }
    }

    public T pop() {
        if (isEmpty()) {
            System.err.println("Stack đang rỗng, chúng ta không thể lấy ra được phần tử nào nữa !!!");
            return null;
        } else {
            return this.underArray[this.top--];
        }
    }

    public int size() {
        return this.top + 1;
    }

    public void displayStack() {
        System.out.print("[");
        for (int i = 0; i <= this.top; i++) {
            if (i != this.top){
                System.out.print(this.underArray[i] + ", ");
            } else {
                System.out.print(this.underArray[i]);
            }
        }
        System.out.println("]");
    }
}