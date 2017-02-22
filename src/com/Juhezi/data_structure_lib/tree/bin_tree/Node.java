package com.juhezi.data_structure_lib.tree.bin_tree;

/**
 * Created by qiao1 on 2017/2/7.
 */
public class Node<T> {
    private static String TAG = "Node";

    Node<T> parent;     //父结点
    Node<T> leftChild;  //左子树结点
    Node<T> rightChild; //右子树结点
    private T value;

    //空的构造函数
    public Node() {
    }

    public Node(T value) {
        this.value = value;
    }

    public Node(Node<T> leftChild, Node<T> parent, Node<T> rightChild, T value) {
        this.leftChild = leftChild;
        this.parent = parent;
        this.rightChild = rightChild;
        this.value = value;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getParent() {
        return parent;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }



}
