package com.codegym;

public abstract class AbstractGenericData<T> {
    protected Integer key;
    protected T next;

    public AbstractGenericData(Integer key) {
        this.key = key;
        this.next = null;
    }

    public abstract String toString();
}