package com.codegym;

import java.lang.reflect.*;

public class MyLinkedListQueue<T extends AbstractGenericData<T>> {
    private T head;
    private T tail;

    public MyLinkedListQueue() {
        this.head = null;
        this.tail = null;
    }

    private boolean isEmpty() {
        return ((this.head == null) && (this.tail == null)) ? true : false;
    }

    @SuppressWarnings("unchecked")
    private T instanceGeneric(int key, Class<T> typeInformation) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, InvocationTargetException {
        return (T) typeInformation.getDeclaredConstructors()[0].newInstance(key);
    }

    public void enQueue(int key, Class<T> typeInformation) throws InstantiationException, IllegalAccessException,
            NoSuchMethodException, SecurityException, InvocationTargetException {
        T newObjectGeneric = instanceGeneric(key, typeInformation);
        if (isEmpty()) {
            this.head = this.tail = newObjectGeneric;
        } else {
            this.tail.next = newObjectGeneric;
            this.tail = newObjectGeneric;
        }
    }

    public T deQueue() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty, so we can get more element !!!");
        } else {
            T elemGeneric = this.head;
            this.head = this.head.next;
            if (this.head == null) {
                this.tail = null;
            }

            return elemGeneric;
        }
    }

    public void displayLinkedListQueue() {
        T currentT = this.head;
        System.out.print("[");
        while (currentT != null) {
            if (currentT.next == null) {
                System.out.print(currentT.toString());
            } else {
                System.out.print(currentT.toString() + ", ");
            }
            currentT = currentT.next;
        }
        System.out.println("]");
    }
}