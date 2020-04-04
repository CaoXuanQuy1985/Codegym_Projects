package com.codegym;

public class MyQueueClient {
    public static void main(String[] args) {
        MyQueue<Node> queue = new MyQueue<Node>(10, Node.class);

        queue.enQueue(new Node(10));
        queue.enQueue(new Node(20));
        queue.enQueue(new Node(30));
        queue.enQueue(new Node(40));
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();

        queue.enQueue(new Node(50));
        queue.enQueue(new Node(60));
        queue.enQueue(new Node(70));
        queue.enQueue(new Node(80));

        while (!queue.isEmpty()) {
            Node n = queue.deQueue();
            System.out.print(n);
            System.out.print(" ");
        }
        System.out.println(" ");
    }
}