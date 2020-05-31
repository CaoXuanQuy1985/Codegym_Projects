package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private String code;
    private String date;

    public Product(){}

    public Product(int id, String name, String code, String date) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
