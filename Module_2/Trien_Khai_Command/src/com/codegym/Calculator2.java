package com.codegym;

public class Calculator2 {
    private IOperators operators;

    public Calculator2(IOperators operator) {
        this.operators = operator;
    }

    public int execute(int firstNumber, int secondNumber) {
        return this.operators.execute(firstNumber, secondNumber);
    }
}
