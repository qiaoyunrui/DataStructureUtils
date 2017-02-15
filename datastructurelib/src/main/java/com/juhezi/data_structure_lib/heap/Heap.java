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

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder("");
        for (Node<T> element : elements) {
            out.append(element.key + " ");
        }
        return out.toString();
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

    /**
     * 删除元素，如果是最大堆，则删除最大元素，如果是最小堆则删除最小元素
     *
     * @return
     */
    public abstract Heap.Node<T> delete(JComparable<T> comparable);

    public static class Node<Y> {
        Y key;

        public Node(Y key) {
            this.key = key;
        }
    }

}
