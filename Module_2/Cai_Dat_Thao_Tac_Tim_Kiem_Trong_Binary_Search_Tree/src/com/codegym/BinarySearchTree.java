package com.codegym;

public class BinarySearchTree<T extends Comparable<T>> extends AbstractTree<T>{
    TreeNode<T> root;
    int size = 0;
    Class<T> kind;

    public BinarySearchTree(){}

    public BinarySearchTree(T[] objects, Class<T> kind) {
        this.kind = kind;
    }

    private TreeNode<T> recursive(T element, TreeNode<T> currentNode, boolean isFind) {
        if (currentNode == null) {
            return null;
        }
        if (element.compareTo(currentNode.element) == 0) {
            if (isFind) {
                return currentNode;
            } else {
                System.out.println("Node is existing, no need insert !!!");
                return currentNode;
            }
        } else if (element.compareTo(currentNode.element) > 0) {
            if (isFind) {
                currentNode = currentNode.right;
                return recursive(element, currentNode, isFind);
            } else {
                if (currentNode.right == null) {
                    TreeNode<T> newNode = new TreeNode<>(element);
                    currentNode.right= newNode;
                    return newNode;
                } else {
                    currentNode = currentNode.right;
                    return recursive(element, currentNode, isFind);
                }
            }
        } else if (element.compareTo(currentNode.element) < 0) {
            if (isFind) {
                currentNode = currentNode.left;
                return recursive(element, currentNode, isFind);
            } else {
                if (currentNode.left == null) {
                    TreeNode<T> newNode = new TreeNode<>(element);
                    currentNode.left = newNode;
                    return newNode;
                } else {
                    currentNode = currentNode.left;
                    return recursive(element, currentNode, isFind);
                }
            }
        } else {
            return recursive(element, currentNode, isFind);
        }
    }

    public TreeNode<T> find(T element) {
        TreeNode<T> currentNode = this.root;
        if (element.compareTo(currentNode.element) == 0) {
            return currentNode;
        } else {
            if (element.compareTo(currentNode.element) < 0) {
                if (currentNode.left == null) {
                    return null;
                } else {
                    currentNode = currentNode.left;
                    return  recursive(element, currentNode, true);
                }
            } else {
                if (currentNode.right == null) {
                    return null;
                } else {
                    currentNode = currentNode.right;
                    return recursive(element, currentNode, true);
                }
            }
        }
    }

    public boolean delete(T element) {
        TreeNode<T> currentNode = this.root;
        TreeNode<T> parrentNode = null;
        boolean isLeftTrue = true;

        while (currentNode.element.compareTo(element) != 0) {
            parrentNode = currentNode;
            if (element.compareTo(currentNode.element) < 0) {
                isLeftTrue = true;
                currentNode = currentNode.left;
            } else {
                isLeftTrue = false;
                currentNode = currentNode.right;
            }
            if (currentNode == null) {
                return false;
            }
        }

        if (currentNode.left == null && currentNode.right == null) {
            if (currentNode == root) {
                root = null;
            } else if (isLeftTrue) {
                parrentNode.left = null;
            } else {
                parrentNode.right = null;
            }
        } else if (currentNode.right == null) {
            if (currentNode == root) {
                root = currentNode.left;
            } else if (isLeftTrue) {
                parrentNode.left = currentNode.left;
            } else {
                parrentNode.right = currentNode.left;
            }
        } else if (currentNode.left == null) {
            if (currentNode == root) {
                root = currentNode.right;
            } else if (isLeftTrue) {
                parrentNode.left = currentNode.right;
            } else {
                parrentNode.right = currentNode.right;
            }
        }

        return true;
    }

    public boolean insert(T element) {
        TreeNode<T> newNode = new TreeNode<T>(element);
        if (this.root == null) {
            this.root = newNode;
            return true;
        }
        TreeNode<T> currentNode = this.root;
        if (element.compareTo(currentNode.element) == 0) {
            System.out.println("Node is existing, no need insert !!!");
        } else {
            if (element.compareTo(currentNode.element) < 0) {
                if (this.root.left == null) {
                    this.root.left = newNode;
                    return true;
                } else {
                    currentNode = this.root.left;
                    recursive(element, currentNode, false);
                }
            } else {
                if (this.root.right == null) {
                    this.root.right = newNode;
                    return true;
                } else {
                    currentNode = this.root.right;
                    recursive(element, currentNode, false);
                }
            }
        }
        return true;
    }

    public int getSize(){
        return -1;
    }

    public void preOrderTraversal(TreeNode<T> root) {
        TreeNode<T> currentNode = root;

        if (currentNode != null) {
            System.out.print(currentNode + ", ");
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }
}