package com.codegym;

import java.util.LinkedList;

public class MyGenericStack<T> {
    private LinkedList<T> underLinkedList;

    public MyGenericStack() {
        this.underLinkedList = new LinkedList<T>();
    }

    public void push(T elem) {
        this.underLinkedList.addFirst(elem);
    }

    public T pop() {
        return this.underLinkedList.removeFirst();
    }

    public boolean isEmpty() {
        return (this.underLinkedList.peek() == null);
    }

    public int size() {
        return this.underLinkedList.size();
    }
}