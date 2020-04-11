package com.codegym;

import java.io.Serializable;

class Sugar extends Production implements Serializable {
    public Sugar(String name, String code, String original, double price, int quantity) {
        super(name, code, original, price, quantity);
     }
}