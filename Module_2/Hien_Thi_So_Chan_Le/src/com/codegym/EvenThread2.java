package com.codegym;

import java.util.concurrent.*;

public class EvenThread2 extends Thread {
    private OddThread2 oddThread;
    public EvenThread2(OddThread2 oddThread) {
        this.oddThread = oddThread;
        this.start();
    }
    public String toString() {
        return "EvenThread2[" + getName() + "] ";
    }
    public void run() {
        try {
            oddThread.join();
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