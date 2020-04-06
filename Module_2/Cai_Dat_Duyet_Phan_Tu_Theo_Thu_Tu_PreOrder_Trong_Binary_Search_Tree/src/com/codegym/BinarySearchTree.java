package com.codegym;

public class BinarySearchTree<T extends AbstractData<T>> {
    T root;
    Class<T> kind;

    public BinarySearchTree(Class<T> kind) {
        this.kind = kind;
    }

    @SuppressWarnings("unchecked")
    private T recursive(int key, T currentNode, boolean isFind) throws Exception {
        if (currentNode == null) {
            return null;
        }
        if (currentNode.key == key) {
            if (isFind) {
                return currentNode;
            } else {
                System.out.println("Node is existing, no need insert !!!");
                return currentNode;
            }
        } else if (currentNode.key < key) {
            if (isFind) {
                currentNode = currentNode.rightChild;
                return recursive(key, currentNode, isFind);
            } else {
                if (currentNode.rightChild == null) {
                    T newNode = (T) this.kind.getConstructors()[0].newInstance(key);
                    currentNode.rightChild = newNode;
                    return newNode;
                } else {
                    currentNode = currentNode.rightChild;
                    return recursive(key, currentNode, isFind);
                }
            }
        } else if (currentNode.key > key) {
            if (isFind) {
                currentNode = currentNode.leftChild;
                return recursive(key, currentNode, isFind);
            } else {
                if (currentNode.leftChild == null) {
                    T newNode = (T) this.kind.getConstructors()[0].newInstance(key);
                    currentNode.leftChild = newNode;
                    return newNode;
                } else {
                    currentNode = currentNode.leftChild;
                    return recursive(key, currentNode, isFind);
                }
            }
        } else {
            return recursive(key, currentNode, isFind);
        }
    }

    public T find(int key) throws Exception {
        T currentNode = this.root;
        if (currentNode.key == key) {
            return currentNode;
        } else {
            if (currentNode.key > key) {
                if (currentNode.leftChild == null) {
                    return null;
                } else {
                    currentNode = currentNode.leftChild;
                    return (T) recursive(key, currentNode, true);
                }
            } else {
                if (currentNode.rightChild == null) {
                    return null;
                } else {
                    currentNode = currentNode.rightChild;
                    return (T) recursive(key, currentNode, true);
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void insert(int id) throws Exception{
        T newNode = (T) this.kind.getConstructors()[0].newInstance(id);
        if (this.root == null) {
            this.root = newNode;
            return;
        }
        T currentNode = this.root;
        if (currentNode.key == id) {
            System.out.println("Node is existing, no need insert !!!");
        } else {
            if (currentNode.key > id) {
                if (this.root.leftChild == null) {
                    this.root.leftChild = newNode;
                    return;
                } else {
                    currentNode = this.root.leftChild;
                    recursive(id, currentNode, false);
                }
            } else {
                if (this.root.rightChild == null) {
                    this.root.rightChild = newNode;
                    return;
                } else {
                    currentNode = this.root.rightChild;
                    recursive(id, currentNode, false);
                }
            }
        }
    }

    public void preOrderTraversal(Node root) {
        Node currentNode = root;

        if (currentNode != null) {
            System.out.print(currentNode + ", ");
            preOrderTraversal(root.leftChild);
            preOrderTraversal(root.rightChild);
        }
    }
}