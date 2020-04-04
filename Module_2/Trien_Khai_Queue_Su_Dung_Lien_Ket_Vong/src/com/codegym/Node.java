package com.codegym;

public class Node extends AbstractGenericData<Node>{
    public Node(Integer key) {
        super(key);
    }
    public String toString() {
        return "Node[" + this.key + "]";
    }
}