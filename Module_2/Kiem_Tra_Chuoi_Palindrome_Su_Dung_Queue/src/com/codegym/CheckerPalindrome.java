package com.codegym;

import java.util.*;

public class CheckerPalindrome {
    private Stack<Character> stack;
    private Queue<Character> queue;
    private static Scanner sc;

    public CheckerPalindrome() {
        this.stack = new Stack<>();
        this.queue = new LinkedList<>();
    }

    public boolean isPalindrome(String sourceString) {
        char[] arrayChar = sourceString.toCharArray();

        for (char c : arrayChar) {
            this.stack.push((Character)c);
            this.queue.offer((Character)c);
        }

        while (!this.stack.isEmpty()) {
            Character charInStack = this.stack.pop();
            Character charInQueue = this.queue.poll();
            if (!(Character.toUpperCase(charInStack) == (Character.toUpperCase(charInQueue)))) {
                return false;
            }
        }

        return true;
    }

    public String getString() {
        sc = new Scanner(System.in);

        if (sc.hasNextLine()) {
            return sc.nextLine();
        }
        System.out.println("Error reading String, try again !!!");
        return getString();
    }
}