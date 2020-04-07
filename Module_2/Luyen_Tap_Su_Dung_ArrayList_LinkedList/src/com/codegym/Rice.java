package com.codegym;

public class Rice extends Production {
    public Rice(String name, double price) {
        super(name, price);
    }
    public String toString() {
        return "{Rice: id = " + this.getId() + " - Name: " + this.getName() + " - Price: " + this.getPrice() +"}";
    }
}