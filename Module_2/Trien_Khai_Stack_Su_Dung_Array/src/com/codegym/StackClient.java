package com.codegym;

public class StackClient {
    public static void main(String[] args) {
        MyStack<Node> stack = new MyStack<Node>(10, Node.class);
        System.out.println("Thử nghiệm kiểu dữ liệu đầu tiên: Node với Stack Generic:");
        System.out.println("Thực hiện toán tử push():");
        try {
            for (int i = 1; i <= 10; i++) {
                stack.push(new Node(i));
            }
            System.out.println("Sau khi thực hiện toán tử push() Stack có các phần tử sau: ");
            System.out.println("Kích thước của Stack là: " + stack.size());
            stack.displayStack();
            System.out.println("Thực hiện toán tử pop():");

            for (int i = 1; i < 4; i++) {
                stack.pop();
            }

            System.out.println("Sau khi thực hiện toán tử pop() Stack có các phần tử sau: ");
            System.out.println("Kích thước của Stack là: " + stack.size());
            stack.displayStack();

            System.out.println("-----------Thử nghiệm kiểu dữ liệu khác : Employee với Stack để kiểm tra tính năng Generic");

            MyStack<Employee> stack2 = new MyStack<Employee>(10, Employee.class);
            System.out.println("Thực hiện toán tử push():");
            for (int i = 1; i <= 10; i++) {
                stack2.push(new Employee(i));
            }
            System.out.println("Sau khi thực hiện toán tử push() Stack có các phần tử sau: ");
            System.out.println("Kích thước của Stack là: " + stack2.size());
            stack2.displayStack();

            System.out.println("Thực hiện toán tử pop():");
            for (int i = 1; i < 6; i++) {
                stack2.pop();
            }

            System.out.println("Sau khi thực hiện toán tử pop() Stack có các phần tử sau: ");
            System.out.println("Kích thước của Stack là: " + stack2.size());
            stack2.displayStack();
        } catch (Exception ex) {
            System.err.println("Có lỗi biệt lệ đã được quăng ra !!!");
        }
    }
}
