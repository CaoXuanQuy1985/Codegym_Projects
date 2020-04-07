package com.codegym;

import java.util.*;

public abstract class Production implements Comparator<Production> {
    private static int counter = 1;
    protected int id = counter++;
    protected String name;
    protected double price;

    public Production(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public abstract String toString();

    public int compare(Production p1, Production p2) {
        return (p1.price < p2.price) ? -1 : ((p1.price == p2.price) ? 0 : 1);
    }
}