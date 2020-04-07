package com.codegym;

class Milk extends Production {
    public Milk(String name, double price) {
        super(name, price);
    }
    public String toString() {
        return "{Milk: id = " + this.getId() + " - Name: " + this.getName() + " - Price: " + this.getPrice() + "}";
    }
}