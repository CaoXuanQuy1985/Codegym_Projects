package com.codegym;

import java.io.Serializable;

class Coffee extends Production implements Serializable {
    public Coffee(String name, String code, String original, double price, int quantity) {
        super(name, code, original, price, quantity);
     }
}