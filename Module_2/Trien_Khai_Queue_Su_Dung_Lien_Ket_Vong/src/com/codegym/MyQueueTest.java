package com.codegym;

public class MyQueueTest {
    public static void main(String[] args) {
        try {
            MyQueue<Node> queue = new MyQueue<Node>();

            System.out.println("Thực hiện phép xử lý enqueue: ");
            for (int i = 1; i <= 10; i++) {
                queue.enQueue(i, Node.class);
            }
            queue.displayQueue();

            System.out.println("Thực hiện phép xử lý dequeue: ");
            for (int i = 1; i <= 4; i++) {
                queue.deQueue();
            }
            System.out.println("Queue sau khi thực hiện phép xử lý dequeue: ");
            queue.displayQueue();

            /*
             * System.out.println("Thực hiện phép xử lý dequeue khi queue là rỗng : "); for
             * (int i = 1; i <= 7; i++) { queue.deQueue(); } System.out.
             * println("Queue sau khi thực hiện phép xử lý dequeue với queue rỗng : ");
             * queue.displayLinkedListQueue();
             */
            System.out.println(
                    "---------- Thực hiện Queue với kiểu dữ liệu khác Ví dụ: Employee để kiểm tra tính năng Generic ");
            System.out.println();
            MyQueue<Employee> queue_2 = new MyQueue<>();

            System.out.println("Thực hiện phép xử lý enqueue: ");
            queue_2.enQueue(14, Employee.class);
            queue_2.enQueue(22, Employee.class);
            queue_2.displayQueue();
            queue_2.enQueue(-6, Employee.class);
            queue_2.displayQueue();

            System.out.println("Thực hiện phép xử lý dequeue: ");
            queue_2.deQueue();
            queue_2.displayQueue();
            queue_2.deQueue();
            System.out.println("Queue sau khi thực hiện phép xử lý dequeue: ");
            queue_2.displayQueue();

            System.out.println("Thực hiện phép xử lý enqueue: ");
            queue_2.enQueue(9, Employee.class);
            queue_2.displayQueue();
            queue_2.enQueue(20, Employee.class);
            queue_2.displayQueue();

        } catch (InstantiationException ex) {
            System.err.println("InstantiationException has been thrown !!!");
        } catch (IllegalAccessException ex2) {
            System.err.println("IllegalAccessException has been thrown !!!");
        } catch (Exception ex3) {
            System.err.println("Exception has been thrown !!!");
        }
    }
}