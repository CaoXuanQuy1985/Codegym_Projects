package com.codegym;

public class LinkedListQueueTest {
    public static void main(String[] args) {
        try {
            MyLinkedListQueue<Node> queue = new MyLinkedListQueue<>();

            System.out.println("Thực hiện phép xử lý enqueue: ");
            for (int i = 1; i <= 10; i++){
                queue.enQueue(i, Node.class);
            }
            queue.displayLinkedListQueue();

            System.out.println("Thực hiện phép xử lý dequeue: ");
            for (int i = 1; i <= 4; i++) {
                queue.deQueue();
            }
            System.out.println("Queue sau khi thực hiện phép xử lý dequeue: ");
            queue.displayLinkedListQueue();

            /*System.out.println("Thực hiện phép xử lý dequeue khi queue là rỗng : ");
            for (int i = 1; i <= 7; i++) {
                queue.deQueue();
            }
            System.out.println("Queue sau khi thực hiện phép xử lý dequeue với queue rỗng : ");
            queue.displayLinkedListQueue();*/
            System.out.println("---------- Thực hiện Queue với kiểu dữ liệu khác Ví dụ: Employee ");
            System.out.println();
            MyLinkedListQueue<Employee> queue_2 = new MyLinkedListQueue<>();

            System.out.println("Thực hiện phép xử lý enqueue: ");
            for (int i = 1; i <= 10; i++){
                queue_2.enQueue(i, Employee.class);
            }
            queue_2.displayLinkedListQueue();

            System.out.println("Thực hiện phép xử lý dequeue: ");
            for (int i = 1; i <= 10; i++) {
                queue_2.deQueue();
            }
            queue_2.deQueue();
            System.out.println("Queue sau khi thực hiện phép xử lý dequeue: ");
            queue_2.displayLinkedListQueue();

        } catch (InstantiationException ex) {
            System.err.println("InstantiationException has been thrown !!!");
        } catch (IllegalAccessException ex) {
            System.err.println("IllegalAccessException has been thrown !!!");
        } catch (Exception ex) {
            System.err.println("Exception has been thrown !!!");
        }
    }
}