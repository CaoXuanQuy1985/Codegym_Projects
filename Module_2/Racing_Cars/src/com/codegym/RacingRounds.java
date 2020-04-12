package com.codegym;

import java.util.concurrent.*;

public class RacingRounds {
    static final int DISTANCE = 100;
    static final int STEP = 2;
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        Car carA = new Car("A");
        Car carB = new Car("B");
        Car carC = new Car("C");

        System.out.println("DISTANCE = " + DISTANCE);
        exec.execute(carA);
        exec.execute(carB);
        exec.execute(carC);

        exec.shutdown();
    }
}