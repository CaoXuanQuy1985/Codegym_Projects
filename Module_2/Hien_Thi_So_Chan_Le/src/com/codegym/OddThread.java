package com.codegym;

import java.util.concurrent.TimeUnit;

public class OddThread extends Thread{
    public OddThread() {
        this.start();
    }
    public String toString() {
        return "OddThread[" + getName() + "] ";
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