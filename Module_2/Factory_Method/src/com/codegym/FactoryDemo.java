package com.codegym;

public class FactoryDemo {
    public static void main(String[] args) {
        AnimalFactory factory = new AnimalFactory();

        Animal a1 = factory.getAnimal("John");
        System.out.println("a1 sound: " + a1.makeSound());
        Animal a2 = factory.getAnimal("Canine");
        System.out.println("a2 sound: " + a2.makeSound());
    }
}