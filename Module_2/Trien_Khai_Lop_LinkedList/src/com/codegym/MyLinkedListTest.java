package com.codegym;

public class MyLinkedListTest {
    public static void main(String[] args) throws Exception {
        MyLinkedList<Node> linkedList = new MyLinkedList<Node>(10);
        linkedList.displayLinkedList();

        try { 
            System.out.println("Thực hiện phép toán gán vào đầu addFirrst:");
            linkedList.addFirst(Node.class, "Node", 1);
            linkedList.addFirst(Node.class, "Node", 2);
            linkedList.addFirst(Node.class, "Node", 3);
            linkedList.addFirst(Node.class, "Node", 4);
            linkedList.addFirst(Node.class, "Node", 5);
            linkedList.addFirst(Node.class, "Node", 6);
            linkedList.addFirst(Node.class, "Node", 7);
            linkedList.addFirst(Node.class, "Node", 8);
            linkedList.addFirst(Node.class, "Node", 9);

            linkedList.displayLinkedList();
            System.out.println();

            System.out.println("Thực hiện phép toán gán vào chỉ số bất kì  add(index):");
            linkedList.add(3, Node.class, "Node", 12);
            linkedList.displayLinkedList();
            System.out.println();
            linkedList.add(5, Node.class, "Node", 17);

            linkedList.displayLinkedList();
            System.out.println();

            System.out.println("Thực hiện phép toán gán vào cuối List  addLast :");
            linkedList.addLast(Node.class, "Node", 10);
            linkedList.addLast(Node.class, "Node", 11);
            linkedList.addLast(Node.class, "Node", 12);
            linkedList.displayLinkedList();
            System.out.println();
            System.out.println("Lấy phần tử tại chỉ số index = 3 : " + linkedList.get(3));

            System.out.println("Xóa phần tử " + linkedList.delete(17));
            System.out.println("LinkedList sau khi xóa: ");
            linkedList.displayLinkedList();
            System.out.println();

            System.out.println("Xóa phần tử " + linkedList.delete(10));
            System.out.println("LinkedList sau khi xóa: ");
            linkedList.displayLinkedList();
            System.out.println();
        } catch (InstantiationException ex) {
            System.err.println("Biệt lệ không thể khởi tạo được thực thể");
        } catch (IllegalAccessException ex2) {
            System.err.println("Biệt lệ truy cập bất hợp pháp đã được quẳng ra, xin  lỗi !!!");
        }
    }
}