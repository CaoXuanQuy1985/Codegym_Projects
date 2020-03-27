package com.codegym;

class Chicken extends Animal implements Edible{
    @Override
    public void makeSound() {
        System.out.println("Chicken says \"Cuc tac Cuc tac\"");
    }
    @Override
    public void howToEat() {
        System.out.println("We can boil chickens to eat");
    }
}