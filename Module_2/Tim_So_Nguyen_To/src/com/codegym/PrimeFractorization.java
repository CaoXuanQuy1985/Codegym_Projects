package com.codegym;

import java.util.concurrent.TimeUnit;

public class PrimeFractorization {
    private LazyPrimeFractorization lazyPrime;
    private OptimizedPrimeFractorization optimizedPrime;

    private class LazyPrimeFractorization implements Runnable {
        Thread thread;
        private String name;
        LazyPrimeFractorization(String name) {
            this.name = name;
            thread = new Thread(this, this.name);
            thread.start();
        }

        private boolean isPrime(int n) {
            if (n == 2)
                return true;
            for (int i = 2; i < n; i++) {
                if (n % i == 0) 
                    return false;
            }
            return true;
        }

        public void run() {
            try {
                 for (int i = 2; i <= 100; i++) {
                     if (isPrime(i)) {
                         System.out.println(this + " " + i);
                     }
                 }
                 TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                System.err.println("Interrupted !!!");
            }
        }
        public String toString() {
            return this.name + " đã tìm được số nguyên tố: ";
        }
    }

    private class OptimizedPrimeFractorization implements Runnable {
        Thread thread;
        private String name;
        OptimizedPrimeFractorization(String name) {
            this.name = name;
            thread = new Thread(this, this.name);
            thread.start();
        }

        private boolean isPrime(int n) {
            if (n == 2)
                return true;
            if (n != 2 && (n % 2 == 0))
                return false;
            for (int i = 3; i < Math.sqrt(n); i += 2) {
                if (n % i == 0) 
                    return false;
            }
            return true;
        }

        public void run() {
            try {
                 for (int i = 2; i <= 100; i++) {
                     if (isPrime(i)) {
                         System.out.println(this + " " + i);
                     }
                 }
                 TimeUnit.MILLISECONDS.sleep(100);
            } catch (InterruptedException ex) {
                System.err.println("Interrupted !!!");
            }
        }
        public String toString() {
            return this.name + " đã tìm được số nguyên tố: ";
        }
    }

    public PrimeFractorization(String name, String name2) {
        lazyPrime = new LazyPrimeFractorization(name);
        optimizedPrime = new OptimizedPrimeFractorization(name2);
    }
}