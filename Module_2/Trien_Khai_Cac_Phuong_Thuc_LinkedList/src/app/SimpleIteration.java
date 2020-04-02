package app;

import typeinfo.pets.*;
import java.util.*;

public class SimpleIteration {
    public static void main(String[] args) {
        List<Pet> pets = Pets.arrayList(12);
        
        Iterator<Pet> iterator = pets.iterator();
        while (iterator.hasNext()) {
            Pet p = iterator.next();
            System.out.println("id = " + p.id() + ", p = " + p);
        }
        System.out.println();

        for (Pet p : pets) {
            System.out.println("id = " + p.id() + ", p = " + p);
        }
        System.out.println();

        iterator = pets.iterator();
        while (iterator.hasNext()) {
            iterator.next();
            iterator.remove();
        }
        System.out.println(pets);
    }
}