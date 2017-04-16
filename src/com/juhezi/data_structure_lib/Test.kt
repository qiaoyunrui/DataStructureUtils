package com.juhezi.data_structure_lib

import com.juhezi.data_structure_lib.list.LinkedList
import com.juhezi.data_structure_lib.sort.bubbleSort
import com.juhezi.data_structure_lib.util.impl.IntegerComparable

/**
 * Created by Juhezi on 2017/4/8.
 */
fun main(args: Array<String>) {
    var array = Array(20, { it })
    bubbleSort(array, IntegerComparable())
    array.forEach { println("$it ") }
}