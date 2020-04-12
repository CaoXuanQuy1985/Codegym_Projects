package com.codegym;

import java.util.concurrent.*;

public class NumberGeneratorClient {
    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();

        NumberGenerator gen1 = new NumberGenerator(Thread.MAX_PRIORITY),
                                    gen2 = new NumberGenerator(Thread.MIN_PRIORITY);

        exec.execute(gen1);
        exec.execute(gen2);

        exec.shutdown();
    }
}