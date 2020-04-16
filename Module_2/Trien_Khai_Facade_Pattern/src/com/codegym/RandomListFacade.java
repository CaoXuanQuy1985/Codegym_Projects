package com.codegym;

import java.util.*;

public class RandomListFacade {
    private RandomList randomList;
    private List<Integer> listInteger;
    private List<Integer> listEven;
    private ListPrinter printer;
    private ListFilter filter;
    private int min, max, size;

    public RandomListFacade(int size, int min, int max) {
        randomList = new RandomList();
        printer = new ListPrinter();
        filter = new ListFilter();
        this.size = size;
        this.min = min;
        this.max = max;
    }

    public void printRandomEvenList() {
        listInteger = randomList.generateList(size, min, max);
        listEven = filter.filterOdd(listInteger);
        printer.printList(listEven);
    }
}