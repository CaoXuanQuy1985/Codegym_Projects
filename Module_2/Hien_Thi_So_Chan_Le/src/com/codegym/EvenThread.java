package com.codegym;

import java.util.concurrent.*;

public class EvenThread extends Thread {
    public EvenThread() {
        this.start();
    }
    public String toString() {
        return "EvenThread[" + getName() + "] ";
    }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 == 0) {
                    System.out.println(this + " i = " + i);
                    TimeUnit.MILLISECONDS.sleep(15);
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Interrupted");
        }
    }
}