package com.codegym;

import java.io.*;

class Milk extends Production implements Serializable {
    public Milk(String name, String code, String original, double price, int quantity) {
       super(name, code, original, price, quantity);
    }
}