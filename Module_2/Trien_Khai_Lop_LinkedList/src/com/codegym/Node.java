package com.codegym;
import java.lang.Comparable;

public class Node extends Executable<Node> implements Comparable<Node> {
    public Node(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return this.data;
    }

    public String toString() {
        return "Node[" + this.data + "]";
    }

    public int compareTo(Node node) {
        return (this.data < node.data) ? -1 : ((this.data == node.data) ? 0 : 1);
    }
}