package com.juhezi.data_structure_lib.sort;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class MergeSort {
    private static String TAG = "MergeSort";

    /**
     * p <= q < r，该过程假设子数组array[p..q]和array[q+1..r]都已经排好序。
     * 它合并这两个子数组形成单一的已排好序的子数组并代替当前的子数组[p..r]
     * <p>
     * 时间复杂度 O(n)
     */
    private static <T> void mergeSort(T[] srcArray, T[] destArray, int low, int high, JComparable<T> comparable) {
        int length = high - low;
        if (length < 3) {
            InsertSort.sort(srcArray, comparable);  //长度不超过3的，使用插入排序
            return;
        }
        int destLow = low;
        int destHeight = high;
        int mid = (low + high) >>> 1;
        mergeSort(srcArray, destArray, low, mid, comparable);
        mergeSort(srcArray, destArray, mid, high, comparable);
        for (int i = destLow, p = low, q = mid; i < destHeight; i++) {
            if (q >= high || p < mid && comparable.moreThan(srcArray[p], srcArray[q])) {
                destArray[i] = srcArray[q++];
            } else {
                destArray[i] = srcArray[p++];
            }
        }
    }

    public static <T> void sort(T[] srcArray, T[] destArray, JComparable<T> comparable) {
        mergeSort(srcArray, destArray, 0, srcArray.length, comparable);
    }

}
