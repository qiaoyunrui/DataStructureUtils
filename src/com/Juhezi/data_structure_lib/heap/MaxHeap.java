package com.juhezi.data_structure_lib.heap;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * 最大堆
 * Created by qiao1 on 2017/2/14.
 */
public class MaxHeap<T> extends Heap<T> {
    private static String TAG = "MaxHeap";

    public MaxHeap(int maxSize) {
        super(maxSize);
    }

    /**
     * 时间复杂度为O(logn)
     *
     * @param node
     * @param comparable
     * @return
     */
    @Override
    public boolean insert(Node<T> node, JComparable<T> comparable) {
        if (isFull())
            return false;
        int i = size;
        while ((i != 0) &&
                comparable.moreThan(node.key, elements[(i - 1) >>> 1].key)) {
            elements[i] = elements[(i - 1) >>> 1];
            i = (i - 1) >>> 1;
        }
        elements[i] = node;
        size++;
        return true;
    }

    /**
     * 删除最大元素（即根结点）
     * 时间复杂度为logn
     *
     * @param comparable
     * @return
     */
    @Override
    public Node<T> delete(JComparable<T> comparable) {
        if (isEmpty())
            return null;
        Node<T> max = elements[0];    //最大结点
        Node<T> detail = elements[size - 1];    //尾部元素
        int parent = 0, child = 1;  //代表下标
        while (child < size) {
            //取两个子结点中最大的
            if (child < size - 1 &&
                    comparable.lessThan(elements[child].key, elements[child + 1].key))
                child++;
            if (comparable.moreOrEquals(detail.key, elements[child].key))
                break;
            //移到低等级
            elements[parent] = elements[child];
            parent = child;
            child = child << 1 + 1;
        }
        elements[parent] = detail;
        size--;
        elements[size] = null;
        return max;
    }
}
