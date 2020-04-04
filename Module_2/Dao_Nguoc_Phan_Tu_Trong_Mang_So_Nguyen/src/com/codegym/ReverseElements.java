package com.codegym;

import java.util.Stack;
import java.lang.reflect.*;

public class ReverseElements<T> {
    private Stack<T> stack;
    private Class<T> kind;
    private T[] array;

    public ReverseElements(Class<T> kind) {
        this.stack = new Stack<>();
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    public T[] reverseArray(T[] array) {
        this.array = (T[]) Array.newInstance(kind, array.length);
        for (T elem : array) {
            this.stack.push(elem);
        }

        int index = 0;
        while (!this.stack.isEmpty()) {
            this.array[index++] = this.stack.pop();
        }

        return this.array;
    }
}