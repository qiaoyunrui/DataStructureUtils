package com.juhezi.data_structure_lib.heap;


import com.juhezi.data_structure_lib.util.JComparable;

/**
 * Created by qiao1 on 2017/2/14.
 */
public abstract class Heap<T> {
    private static String TAG = "Heap";

    private static int MAX_SIZE;

    protected Node<T>[] elements;

    protected int size;

    public Heap(int maxSize) {
        MAX_SIZE = maxSize;
        elements = new Node[maxSize];
        size = 0;
    }

    public boolean isFull() {
        return size == MAX_SIZE;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 向队中插入元素
     *
     * @param node
     * @return true -> 插入成功
     * false -> 插入失败
     */
    public abstract boolean insert(Node<T> node, JComparable<T> comparable);

    public static class Node<Y> {
        Y key;
    }

}
