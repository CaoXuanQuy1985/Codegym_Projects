package com.codegym;

import java.lang.reflect.*;

public class MyQueue<T extends AbstractGenericData<T>> {
    private T head;
    private T tail;

    public MyQueue() {
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
            newObjectGeneric.next = this.head;
        } else {
            this.tail.next = newObjectGeneric;
            this.tail = newObjectGeneric;
            newObjectGeneric.next = this.head;
        }
    }

    public T deQueue() throws Exception{
        if (isEmpty()) {
            throw new Exception("Queue is Empty, so we can get more element !!!");
        } else {
            T elemGeneric = this.head;
            this.head = this.head.next;
            this.tail.next = this.head;
            if (this.head == null) {
                this.tail = null;
            }

            return elemGeneric;
        }
    }

    public void displayQueue() {
        T currentT = this.head.next;
        System.out.print("[" + this.head + ", ");
        while (currentT != this.head) {
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