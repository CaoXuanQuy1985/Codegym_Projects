package app;

import java.util.*;
import typeinfo.pets.*;

public class LinkedListFeatures {
    public static void main(String[] args) {
        LinkedList<Pet> pets = new LinkedList<Pet>(Pets.arrayList(8));

        System.out.println(pets);
        System.out.println("pets.getFirst(): " + pets.getFirst());
        System.out.println("pets.element(): " + pets.element());

        System.out.println("peek(): " + pets.peek());

        System.out.println("remove(): " + pets.remove());
        System.out.println("removeFirst(): " + pets.removeFirst());
        System.out.println("poll(): " + pets.poll());

        System.out.println(pets);

        pets.addFirst(new Rat());
        System.out.println("After addFirst(): " + pets);
        pets.offer(Pets.randomPet());
        System.out.println("After offer(): " + pets);
        pets.add(Pets.randomPet());
        System.out.println("After add(): " + pets);
        pets.addLast(Pets.randomPet());
        System.out.println("After addLast(): " + pets);
        pets.removeLast();
        System.out.println("After removeLast(): " + pets);
    }
}