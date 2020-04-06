package com.codegym;

public class BinarySearchTreeApp {
    public static void main(String[] args) {
        BinarySearchTree<Node> bst = new BinarySearchTree<>(Node.class);
        try {
            bst.insert(31);
            bst.insert(25);
            bst.insert(74);
            bst.insert(22);
            bst.insert(30);
            bst.insert(62);
            bst.insert(92);
            bst.insert(0);
            bst.insert(24);
            bst.insert(44);
            bst.insert(71);
            bst.insert(76);
            bst.insert(95);
            bst.insert(2);
            bst.insert(37);
            bst.insert(50);
            bst.insert(73);

            bst.preOrderTraversal(bst.root);
        } catch (Exception ex) {
            System.err.println("Exception has been thrown !!!");
        }
    }
}