package com.juhezi.data_structure_lib.sort

import com.juhezi.data_structure_lib.util.JComparable
import com.sun.org.apache.xml.internal.utils.res.IntArrayWrapper

/**
 * Created by Juhezi on 2017/4/9.
 *
 * 归并排序
 * 效率为O(n log n)
 *
 */
fun <T> mergeSort(array: Array<T>, comparable: JComparable<T>?) {
    if (comparable == null) throw NullPointerException("The JComparable can not be null!")
    var len = 1
    var sortedArray = array.clone()
    while (len < array.size) {
        mergePass(array, sortedArray, len, comparable)
        len *= 2
        mergePass(sortedArray, array, len, comparable)
        len *= 2
    }
}

/**
 * 简单的合并，时间复杂度为 O(n)
 */
private fun <T> merge(array: Array<T>, sortedArray: Array<T>, start: Int, center: Int, end: Int,
                      comparable: JComparable<T>) {
    if (start < 0 || center < 0 || end < 0 ||
            start >= array.size || center >= array.size || end >= array.size)
        return
    if (start > center || start > end || center > end)
        return
    if (array.size != sortedArray.size)
        return
    var i = start   //index for the first sublist
    var j = center + 1  //index for the second sublist
    var k = start   //index for the sorted list
    while (i <= center && j <= end) {
        if (comparable.lessOrEquals(array[i], array[j])) {  //second sublist big
            sortedArray[k++] = array[i++]
        } else {
            sortedArray[k++] = array[j++]
        }
    }
    if (i > center) {   //the first sublist is over
        for (t in j..end) {
            sortedArray[k + t - j] = array[t]
        }
    } else {    //the second sublist is over
        for (t in i..center) {
            sortedArray[k + t - i] = array[t]
        }
    }
}

/**
 * 执行单遍归并的函数
 */
private fun <T> mergePass(array: Array<T>, sortedArray: Array<T>, len: Int, comparable: JComparable<T>) {
    var i = 0
    var n = array.size
    while (i <= n - 2 * len) {
        merge(array, sortedArray, i, i + len - 1, i + 2 * len - 1, comparable)
        i += 2 * len
    }
    if (i + len < n) {
        merge(array, sortedArray, i, i + len - 1, n - 1, comparable)
    } else {
        for (j in i..n - 1) {
            sortedArray[j] = array[j]
        }
    }
}
