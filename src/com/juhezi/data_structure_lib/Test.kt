package com.juhezi.data_structure_lib

import com.juhezi.data_structure_lib.search.binSearch
import com.juhezi.data_structure_lib.sort.MergeSort
import com.juhezi.data_structure_lib.sort.heapSort
import com.juhezi.data_structure_lib.sort.mergeSort
import com.juhezi.data_structure_lib.util.impl.IntegerComparable

/**
 * Created by Juhezi on 2017/4/8.
 */
fun main(args: Array<String>) {
    var array = Array(20, { 20 - it })
    heapSort(array, IntegerComparable())
    array.forEach { println(" $it") }
}