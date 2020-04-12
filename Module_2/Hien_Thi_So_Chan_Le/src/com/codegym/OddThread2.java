package com.codegym;

import java.util.concurrent.*;

public class OddThread2 extends Thread {
    public OddThread2() {
        this.start();
    }
    public String toString() {
        return "OddThread2[" + getName() + "] ";
    }
    public void run() {
        try {
            for (int i = 1; i <= 10; i++) {
                if (i % 2 != 0) {
                    System.out.println(this + " i = " + i);
                    TimeUnit.MILLISECONDS.sleep(10);
                }
            }
        } catch (InterruptedException ex) {
            System.err.println("Interrupted");
        }
    }
}