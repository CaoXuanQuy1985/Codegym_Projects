package com.codegym;

public class GenericStackClient {
    public static void stackOfStrings() {
        MyGenericStack<String> stackString = new MyGenericStack<String>();

        stackString.push("Five");
        stackString.push("Four");
        stackString.push("Three");
        stackString.push("Two");
        stackString.push("One");

        System.out.println("Size of Stack after push() operator:" + stackString.size());

        System.out.println("Pop element from Stack:");
        while (!stackString.isEmpty()) {
            System.out.printf("%s ", stackString.pop());
        }

        System.out.println("Size of Stack after pop() operator:" + stackString.size());
    }

    public static void stackOfIntegers() {
        MyGenericStack<Integer> stackIntegers = new MyGenericStack<>();

        stackIntegers.push(5);
        stackIntegers.push(4);
        stackIntegers.push(3);
        stackIntegers.push(2);
        stackIntegers.push(1);

        System.out.println("Size of Stack after push() operator:" + stackIntegers.size());

        System.out.println("Pop element from Stack:");
        while (!stackIntegers.isEmpty()) {
            System.out.printf("%d ", stackIntegers.pop());
        }

        System.out.println("Size of Stack after pop() operator:" + stackIntegers.size());
    }

    public static void main(String[] args) {
        stackOfStrings();
        stackOfIntegers();
    }
}