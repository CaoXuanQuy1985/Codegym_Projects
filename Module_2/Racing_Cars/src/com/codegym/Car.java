package com.codegym;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Car implements Runnable {
    private static Random rand = new Random(47);
    private String name;

    public Car(String name) {
        this.name = name;
    }

    public void run() {
        int currentDistance = 0;
        int distance = RacingRounds.DISTANCE;
        int step = RacingRounds.STEP;
        long startTime = System.currentTimeMillis();

        try {
            while (currentDistance < distance) {
                int speed = rand.nextInt(20);
                currentDistance += speed;


                String log = "|";
                for (int i = 0; i < distance; i += step) {
                    if (i + step < currentDistance)
                        log += "=";
                    else if (i + step >= currentDistance && currentDistance > i)
                        log += "o";
                    else
                        log += "-";
                }
                log += "|";
                System.out.println("Car" + this.name + ": " + log + " " + Math.min(currentDistance, distance) + "Km");
            }

            long endTime = System.currentTimeMillis();
            System.out.println("Car" + this.name + " Finishing in " + (endTime - startTime) + "s");
            TimeUnit.MILLISECONDS.sleep(100);
        } catch (InterruptedException ex) {
            System.err.println("Interrupted !!!");
        }
    }
}