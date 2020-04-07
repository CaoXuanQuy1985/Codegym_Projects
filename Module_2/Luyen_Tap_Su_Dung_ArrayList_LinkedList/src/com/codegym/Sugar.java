package com.codegym;

public class Sugar extends Production{
    public Sugar(String name, double price) {
        super(name, price);
    }
    public String toString() {
        return "{Sugar: id = " + this.getId() + " - Name: " + this.getName() + " - Price: " + this.getPrice() + "}";
    }
}