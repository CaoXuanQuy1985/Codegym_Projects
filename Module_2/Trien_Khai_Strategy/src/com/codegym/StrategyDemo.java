package com.codegym;

public class StrategyDemo {
    private static void execute(Strategy strategy) {
        strategy.solve();
    }
    public static void main(String[] args) {
        Strategy[] algorithms = {new Bar(), new Foo()};

        for (Strategy algorithm : algorithms) {
            execute(algorithm);
        }
    }
}
