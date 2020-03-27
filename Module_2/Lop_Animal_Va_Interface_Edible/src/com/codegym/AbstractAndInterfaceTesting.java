package com.codegym;

public class AbstractAndInterfaceTesting {
    public static void main(String[] args) {
        Animal[] animals = new Animal[2];

        animals[0] = new Tiger();
        animals[1] = new Chicken();

        for(Animal animal : animals) {
            animal.makeSound();

            if(animal instanceof Chicken) {
                ((Chicken)animal).howToEat();
            }
        }

        Fruit[] fruits = new Fruit[2];

        fruits[0] = new Orange();
        fruits[1] = new Apple();

        for(Fruit fruit : fruits) {
            fruit.howToEat();
        }
    }
}