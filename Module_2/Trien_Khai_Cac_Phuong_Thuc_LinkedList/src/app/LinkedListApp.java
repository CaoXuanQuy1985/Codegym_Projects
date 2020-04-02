package app;

public class LinkedListApp {
    public static void main(String[] args) {
        MyLinkedList mll = new MyLinkedList();
        mll.insertFirst(5, 5.5);
        mll.insertFirst(6, 6.5);
        mll.insertFirst(7, 7.5);
        mll.insertFirst(8, 8.5);
        mll.insertFirst(9, 9.5);

        mll.displayLinkedList();

        //mll.deleteFirst();
        //mll.deleteFirst();
        //mll.displayLinkedList();

        //System.out.println(mll.find(new Link(8, 8.5)));
        //mll.delete(new Link(8, 8.5));
        //mll.displayLinkedList();
        mll.delete(new Link(10, 10.5));
        mll.displayLinkedList();
    }
}