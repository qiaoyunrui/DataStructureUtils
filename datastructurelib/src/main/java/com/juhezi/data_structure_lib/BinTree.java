package com.juhezi.data_structure_lib;

/**
 * 二叉树
 * <p>
 * Created by qiao1 on 2017/2/5.
 */
public class BinTree<T> {
    private static String TAG = "BinTree";

    private static class Node<V> {
        private V value;
        private Node<V> parent = null, leftChild = null, rightChild = null;

        public Node(V value) {
            this.value = value;
        }

        public Node(V value, Node<V> leftChild, Node<V> parent, Node<V> rightChild,) {
            this.leftChild = leftChild;
            this.parent = parent;
            this.rightChild = rightChild;
            this.value = value;
        }

    }

    public BinTree() {

    }

    public boolean isEmpty() {
        return true;
    }



}
