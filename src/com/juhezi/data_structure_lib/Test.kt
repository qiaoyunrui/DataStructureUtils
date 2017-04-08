package com.juhezi.data_structure_lib

import com.juhezi.data_structure_lib.search.binSearch
import com.juhezi.data_structure_lib.util.impl.IntegerComparable

/**
 * Created by Juhezi on 2017/4/8.
 */
fun main(args: Array<String>) {
    var array = Array<Int>(20, { it * 2 })
    println(binSearch(array, 7, IntegerComparable()))
}