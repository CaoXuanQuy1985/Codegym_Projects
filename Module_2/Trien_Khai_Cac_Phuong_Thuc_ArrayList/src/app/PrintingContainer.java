package app;

import java.util.*;

public class PrintingContainer {
    static Collection<String> fill(Collection<String> collection) {
        collection.add("cat");
        collection.add("dog");

        return collection;
    }
    public static void main(String[] args) {
        System.out.println(fill(new ArrayList<String>()));
        System.out.println(fill(new LinkedList<String>()));
    }
}