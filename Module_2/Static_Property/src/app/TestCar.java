package app;

public class TestCar {
    public static void main(String[] args) {
        Car toyota = new Car("Toyota", 2008);
        Car camry = new Car("Camry", 2020);

        System.out.println("Number of car is: " + Car.numberProducts);
    }
}