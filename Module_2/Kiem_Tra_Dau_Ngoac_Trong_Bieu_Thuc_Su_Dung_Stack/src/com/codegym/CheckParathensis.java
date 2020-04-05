package com.codegym;

import java.util.EmptyStackException;
import java.util.Stack;

public class CheckParathensis {
    private Stack<Character> stack;

    public CheckParathensis() {
        this.stack = new Stack<>();
    }

    public boolean isError(String paramString) {
        char[] arrayChar = new char[paramString.length()];

        int count = 0;
        for (char c : paramString.toCharArray()) {
            arrayChar[count++] = c;
        }

        this.stack.clear();
        try {
            for (char c : arrayChar) {
                if ((c == '(') || (c == '[') || (c == '{')) {
                    this.stack.push(c);
                } else if (c == ')') {
                    char cInStack = this.stack.pop();
                    if (cInStack != '(')
                        return false;
                } else if (c == ']') {
                    char cInStack = this.stack.pop();
                    if (cInStack != '[')
                        return false;
                } else if (c == '}') {
                    char cInStack = this.stack.pop();
                    if (cInStack != '{')
                        return false;
                }
            }

            if (this.stack.isEmpty()) {
                return true;
            } else {
                return false;
            }
        } catch (EmptyStackException ex) {
            return false;
        }
    }
}