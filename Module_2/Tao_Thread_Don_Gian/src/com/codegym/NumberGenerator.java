package com.codegym;

import java.util.concurrent.TimeUnit;

public class NumberGenerator implements Runnable {
    private static int count = 1;
    private final int id = count++;
    private int priority;

    public NumberGenerator(int priority) {
        this.priority = priority;
    }

    public String toString() {
        return "NumberGenerator[" + id + "] - hashCode = " + this.hashCode() + " priority = " + Thread.currentThread().getPriority();
    }

    public void run() {
        Thread.currentThread().setPriority(this.priority);
        try {
            for (int i = 1; i <= 10; i++) {
                System.out.println(this + " - " + i);
            }
            TimeUnit.MILLISECONDS.sleep(500);
        } catch (InterruptedException ex) {
            System.err.println(ex);
        }
    }
}