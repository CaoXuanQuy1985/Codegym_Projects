package app;

public class Car {
    private String name;
    private int engine;

    public static int numberProducts = 0;

    public Car(String name, int engine) {
        this.name = name;
        this.engine = engine;

        numberProducts++;
    }
}