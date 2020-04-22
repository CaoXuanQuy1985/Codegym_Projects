package com.codegym;

import java.util.*;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject sub = new Subject();

        new HexObserver(sub);
        new OctObserver(sub);
        new BinObserver(sub);

        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 5; i++) {
            System.out.println("Entering a number: ");
            sub.setState(sc.nextInt());
        }
    }
}
