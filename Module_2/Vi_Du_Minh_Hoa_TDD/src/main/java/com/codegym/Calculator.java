package com.codegym;

public class Calculator {
    public int add(int firstOperand, int secondOperand) {
        // Sprint1: throw new UnsupportedOperationException("not support operator");
        // Sprint 2: return x + y;

        if (firstOperand / 2 + secondOperand / 2 >= Integer.MAX_VALUE / 2) {
            throw new RuntimeException("Exception out of range");
        }

        if (firstOperand / 2 + secondOperand / 2 <= Integer.MIN_VALUE / 2) {
            throw new RuntimeException("Exception out of range");
        }

        return firstOperand + secondOperand;
    }
}