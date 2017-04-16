package com.juhezi.data_structure_lib.sort

import com.juhezi.data_structure_lib.util.JComparable

/**
 * 冒泡排序
 *
 * 它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。
 * 走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。
 * Created by Juhezi on 2017/4/15.
 */
fun <T> bubbleSort(array: Array<T>, comparable: JComparable<T>) {
    if (array.size < 2) return
    array.forEachIndexed({ i, value ->
        for (j in 0..i - 1) {
            if (comparable.lessThan(value, array[j])) {
                var temp = array[i]
                array[i] = array[j]
                array[j] = temp
            }
        }
    })
}