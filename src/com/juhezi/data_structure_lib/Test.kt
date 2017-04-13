package com.juhezi.data_structure_lib

import com.juhezi.data_structure_lib.list.LinkedList

/**
 * Created by Juhezi on 2017/4/8.
 */
fun main(args: Array<String>) {
    var list = LinkedList<Int>()
    for (i in 0..10) {
        list.add(i)
    }
//    list.reversal()
    list.reverseX()
    for (i in 0..9) {
        println(list[i])
    }

}