package com.codegym;

import java.util.Stack;
import java.util.Scanner;

public class ConvertorDecimalToBinary {
    private Stack<Integer> stack;
    private Scanner sc;

    public ConvertorDecimalToBinary() {
        this.stack = new Stack<>();
    }

    public void convertToBinary(int numberDecimal) {
        int frac = 0;

        while (numberDecimal / 2 >= 0) {
            frac = numberDecimal % 2;
            numberDecimal /= 2;
            this.stack.push(frac);

            if (numberDecimal == 0)
                break;
        }
    }

    public int getDecimal() {
        sc = new Scanner(System.in);

        while (sc.hasNextInt()) {
            return sc.nextInt();
        }
        System.out.println("This is not number decimal, try again !!!");
        return getDecimal();
    }

    public void showResult() {
        System.out.println("Kết quả sau khi chuyển sang hệ nhị phân là: ");
        while (!this.stack.isEmpty()) {
            System.out.print(this.stack.pop());
        }
        System.out.println();
    }
}