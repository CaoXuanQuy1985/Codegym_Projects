package com.codegym;

import java.io.Serializable;

public abstract class Production implements Serializable {
    private static int counter = 1;
    private int id = counter++;
    private String name;
    private String code;
    private String original;
    private double price;
    private int quantity;

    public Production(String name, String code, String original, double price, int quantity) {
        this.name = name;
        this.code = code;
        this.original = original;
        this.price = price;
        this.quantity = quantity;
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

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getOriginal() {
        return this.original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

    public double getPrice() {
        return this.price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}