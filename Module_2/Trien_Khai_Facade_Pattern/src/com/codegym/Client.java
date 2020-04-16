package com.codegym;

public class Client {
    public static void main(String[] args) {
        RandomListFacade facade = new RandomListFacade(20, 10, 100);
        facade.printRandomEvenList();
    }
}