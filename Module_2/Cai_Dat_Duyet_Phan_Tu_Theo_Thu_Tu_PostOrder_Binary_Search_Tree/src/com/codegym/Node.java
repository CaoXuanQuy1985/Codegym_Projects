package com.codegym;

public class Node extends AbstractData<Node> {
    public Node(int key) {
        super(key);
    }
    public String toString() {
        return "Node[" + this.key + "]";
    }
}