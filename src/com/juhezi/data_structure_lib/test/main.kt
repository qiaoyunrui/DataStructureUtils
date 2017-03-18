package com.juhezi.data_structure_lib.test

import com.juhezi.data_structure_lib.sort.QuickSort
import com.juhezi.data_structure_lib.util.impl.IntegerComparable

/**
 * Created by Juhezi on 2017/3/18.
 */
fun main(args: Array<String>) {
    var array = Array(20, { 20 - it })
    QuickSort.sort(array, IntegerComparable(), 0, array.size - 1)
    array.forEach(::println)
}