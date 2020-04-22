package com.codegym;

public class HexObserver extends Observer {
    public HexObserver(Subject subject) {
        this.subject = subject;
        this.subject.add(this);
    }

    public void update() {
        System.out.println(" " + Integer.toHexString(subject.getState()));
    }
}
