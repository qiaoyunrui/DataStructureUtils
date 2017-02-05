package com.juhezi.data_structure_lib;

import java.util.Vector;

/**
 * 二叉树
 * <p>
 * Created by qiao1 on 2017/2/5.
 */
public class BinTree<T> {
    private static String TAG = "BinTree";

    private int size;

    private Node<T> rootNode = null;   //根结点

    public static class Node<V> {
        private V value;
        private Node<V> parent = null, leftChild = null, rightChild = null;

        public Node(V value) {
            this.value = value;
        }

        public Node(V value, Node<V> leftChild, Node<V> parent, Node<V> rightChild) {
            this.value = value;
            this.leftChild = leftChild;
            this.parent = parent;
            this.rightChild = rightChild;
        }

        public Node<V> getLeftChild() {
            return leftChild;
        }

        public void setLeftChild(Node<V> leftChild) {
            this.leftChild = leftChild;
        }

        public Node<V> getParent() {
            return parent;
        }

        public void setParent(Node<V> parent) {
            this.parent = parent;
        }

        public Node<V> getRightChild() {
            return rightChild;
        }

        public void setRightChild(Node<V> rightChild) {
            this.rightChild = rightChild;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    /**
     * 创建一个二叉树
     */
    public BinTree() {
        size = 0;
    }


    public BinTree(Node<T> rootNode) {
        this.rootNode = rootNode;
        size = getNodeSize(rootNode);
    }

    /**
     * 获取一个子树的大小
     *
     * @param node
     * @return
     */
    public static int getNodeSize(Node node) {
        return 0;
    }

    /**
     * 二叉树是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param leftBinTree  左子树
     * @param rootNode     根结点
     * @param rightBinTree 右子树
     * @param <Type>       二叉树中存放数据的类型
     * @return 合并后的二叉树
     */
    public static <Type> BinTree<Type> makeBinTree(
            BinTree<Type> leftBinTree, Node<Type> rootNode, BinTree<Type> rightBinTree) {
        return null;
    }

    /**
     * 获取左子树
     *
     * @return
     */
    public BinTree<T> getLeftChild() {
        return null;
    }

    /**
     * 获取右子树
     *
     * @return
     */
    public BinTree<T> getRightChild() {
        return null;
    }

    /**
     * 打印该二叉树
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 克隆二叉树
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    //遍历操作
}
