package app;

import java.util.*;

public class SimpleCollection {
    public static void main(String[] args) {
        Collection<Integer> collection = new ArrayList<Integer>();

        for (int i = 0 ; i < 10; i++) {
            collection.add(i);
        }

        for (Integer i : collection) {
            System.out.println(i);
        }
    }
}