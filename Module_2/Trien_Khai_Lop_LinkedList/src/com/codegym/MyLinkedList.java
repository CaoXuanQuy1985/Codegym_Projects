package com.codegym;

import java.lang.reflect.InvocationTargetException;

public class MyLinkedList<T extends Executable<T>> {
    private T head;
    private int numNode;

    @SuppressWarnings("unchecked")
    public T createInstance(Class<T> typeInformation, String nameClass, Integer data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class objClass = Class.forName("com.codegym." + nameClass);
        T nodeObj = (T)objClass.getConstructors()[0].newInstance(data);
        return nodeObj;
    }

    public MyLinkedList(Integer data){
        head = null;
        this.numNode = 0;
    }

    public void addFirst(Class<T> typeInformation, String nameClass, Integer data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T newNode = createInstance(typeInformation, nameClass, data);
        newNode.next = this.head;
        this.head = newNode;
    }

    public void addLast(Class<T> typeInformation, String nameClass, Integer data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T newNode = createInstance(typeInformation, nameClass, data);
        
        T currentNode = this.head;
        while (currentNode != null) {
            if (currentNode.next == null) {
                currentNode.next = newNode;
                break;
            }
            currentNode = currentNode.next;
        }
    }

    public void add(int index, Class<T> typeInformation, String nameClass, Integer data) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T newNode = createInstance(typeInformation, nameClass, data);

        T currentNode = this.head;
        int count = 0;

        while (currentNode != null) {
            if (count == index - 1) {
                newNode.next = currentNode.next;
                currentNode.next = newNode;
                break;
            }
            currentNode = currentNode.next;
            count++;
        }
        System.out.println("Không thể tìm thấy phần tử cần xóa, hãy nhập chỉ số index khác");
    }

    public T get(int index) {
        T currentNode = this.head;
        int count = 0;

        while (true) {
            if (count == index) {
                return currentNode;
            }
            currentNode = currentNode.next;
            count++;
        }
    }

    public boolean isEmpty() {
        return (this.head == null) ? true :  false;
    }

    public T delete(Integer dataDel) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        T currentNode = this.head;
        T previousNode = null;

        while (currentNode != null) {
            if (currentNode.data == dataDel) {
                previousNode.next = currentNode.next;
                return currentNode;
            }

            previousNode = currentNode;
            currentNode = currentNode.next;
        }

        return null;
    }

    public void displayLinkedList() {
        T currentNode = this.head;
        while (currentNode != null) {
            System.out.print(currentNode.toString() + ", ");
            currentNode = currentNode.next;
        }
    }
}