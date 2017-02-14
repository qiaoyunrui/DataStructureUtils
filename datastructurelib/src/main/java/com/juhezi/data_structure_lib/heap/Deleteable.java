package com.juhezi.data_structure_lib.heap;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * Created by qiao1 on 2017/2/14.
 */
public interface Deleteable<T> {

    /**
     * 删除元素，如果是最大堆，则删除最大元素，如果是最小堆则删除最小元素
     * @return
     */
    Heap.Node<T> delete(JComparable<T> comparable);

}
