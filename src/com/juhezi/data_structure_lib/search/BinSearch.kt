package com.juhezi.data_structure_lib.search

import com.juhezi.data_structure_lib.util.JComparable

/**
 * Created by Juhezi on 2017/4/8.
 * 二分查找（折半查找）
 * 前提条件是被查找的列表是升序的
 * 每次查找都是把要查找的范围平均分成两部分
 */
fun <T> binSearch(array: Array<T>, key: T, comparable: JComparable<T>?): Int {
    if (comparable == null) throw NullPointerException("The comparable can not be null!")
//    return binSearchInternal(array, key, 0, array.size - 1, comparable)
    return binSearchInternal2(array, key, comparable)
}

/**
 * 通过递归实现的
 */
private fun <T> binSearchInternal(array: Array<T>, key: T, start: Int, end: Int,
                                  comparable: JComparable<T>): Int {
    if (start < 0 || end >= array.size || start > end) return -1
    if (start == end && !comparable.equals(array[start], key)) return -1 //不存在
    var center = (start + end).shr(1)
    if (comparable.moreThan(key, array[center])) //key > center
        return binSearchInternal(array, key, center + 1, end, comparable)
    if (comparable.lessThan(key, array[center])) //key < center
        return binSearchInternal(array, key, start, center, comparable)
    return center
}

/**
 * 非递归实现
 */
private fun <T> binSearchInternal2(array: Array<T>, key: T, comparable: JComparable<T>): Int {
    var start = 0
    var end = array.size - 1
    var center: Int
    while (start <= end) {
        if (start == end && !comparable.equals(key, array[start]))
            return -1
        center = (start + end).shr(1)
        if (comparable.moreThan(key, array[center]))
            start = center + 1
        else if (comparable.lessThan(key, array[center]))
            end = center
        else return center
    }
    return -1
}
