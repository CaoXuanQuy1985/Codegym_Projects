package com.codegym;

class Bar extends StrategySearch {
    private int state = 1;

    protected void preProcess() {
        System.out.println("preProcess() ");
    }

    protected void postProcess() {
        System.out.println("postProcess() ");
    }

    protected boolean search() {
        System.out.println("Search - " + state++ + " ");
        return state == 3;
    }
}
