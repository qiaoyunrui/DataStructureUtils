package com.juhezi.data_structure_lib.heap;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * 最小堆
 * Created by qiao1 on 2017/2/15.
 */
public class MinHeap<T> extends Heap<T> {
    private static String TAG = "MinHeap";

    public MinHeap(int maxSize) {
        super(maxSize);
    }

    @Override
    public boolean insert(Node<T> node, JComparable<T> comparable) {
        if (isFull()) return false;
        int i = size;
        while ((i != 0) && comparable.lessThan(node.key, elements[i >>> 1].key)) {
            elements[i] = elements[(i - 1) >>> 1];
            i = (i - 1) >>> 1;
        }
        elements[i] = node;
        size++;
        return false;
    }

    @Override
    public Node<T> delete(JComparable<T> comparable) {
        if (isEmpty())
            return null;
        Node<T> min = elements[0];
        Node<T> detail = elements[size - 1];
        int parent = 0, child = 1;
        while (child < size) {
            if (child < size - 1 &&
                    comparable.moreThan(elements[child].key, elements[child + 1].key))
                child++;
            if (comparable.lessOrEquals(detail.key, elements[child].key))
                break;
            elements[parent] = elements[child];
            parent = child;
            child = child << 1 + 1;
        }
        elements[parent] = detail;
        size--;
        elements[size] = null;
        return min;
    }
}
