package com.codegym;

public class ThreadTest {
    public static void main(String[] args) {
        /*
         * Thread oddThread = new OddThread(), evenThread = new EvenThread();
         */

        System.out.println("Using method join() 2 thread: ");

        OddThread2 oddThread2 = new OddThread2();
        Thread evenThread2 = new EvenThread2(oddThread2);
    }
}