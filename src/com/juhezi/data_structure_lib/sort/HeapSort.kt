package com.juhezi.data_structure_lib.sort

import com.juhezi.data_structure_lib.util.JComparable

/**
 * Created by Juhezi on 2017/4/9.
 *
 * 堆排序，需要用到最大堆这个数据结构
 * 时间复杂度为 O(n log n)
 *
 * 首先将 n 个记录插入到一个初始为空的堆中，然后，将记录从堆中逐个取出。
 *
 */
fun <T> heapSort(array: Array<T>, comparable: JComparable<T>?) {
    if (comparable == null) throw NullPointerException("The comparable can not be null")
    if (array.isEmpty()) return
    var i = (array.size - 1).ushr(1)
    while (i >= 0) {
        adjust(array, i, array.size, comparable)
        i--
    }
    i = array.size - 1
    //每一次都把第一个元素和最后一个元素交换，因为最大堆的第一个元素总是最大的
    //缩小堆的规模，然后对堆进行重新调整
    while (i >= 0) {
        swap(array, 0, i)
        adjust(array, 0, i, comparable)
        i--
    }

}

private fun <T> swap(array: Array<T>, pos1: Int, pos2: Int) {
    if (pos1 >= array.size || pos2 >= array.size || pos1 < 0 || pos2 < 0) return
    var temp = array[pos1]
    array[pos1] = array[pos2]
    array[pos2] = temp
}

/**
 * 创建具有 n 个记录的堆，使用数组构建
 * 参数是一棵二叉树 T，T 的左右子树均满足堆的特质，只有根节点可能不满足
 */
private fun <T> adjust(array: Array<T>, root: Int, n: Int, comparable: JComparable<T>) {
    if (root < 0 || root >= array.size) return
    var rootKey = array[root]
    var temp = array[root]
    var child = root.shl(1) + 1   //left child
    while (child <= n - 1) {
        if ((child < n - 1) && (comparable.lessThan(array[child], array[child + 1]))) {
            child++
        }
        if (comparable.moreThan(rootKey, array[child])) //因为左右子树是最大堆，所以不需要继续进行比较下去
            break
        else {
            array[(child - 1).ushr(1)] = array[child]
            child = child * 2 + 1
        }
    }
    array[child.ushr(1)] = temp
}

