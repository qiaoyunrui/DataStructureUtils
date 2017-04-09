package com.juhezi.data_structure_lib.sort;

import com.juhezi.data_structure_lib.util.JComparable;

import java.util.Arrays;

/**
 * 快速排序
 * 快速排序使用分治法（Divide and conquer）策略来把一个序列（list）分为两个子序列（sub-lists）。
 * 步骤为：
 * 从数列中挑出一个元素，称为"基准"（pivot/key），
 * 重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任一边）。
 * 在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
 * 递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
 * 递归到最底部时，数列的大小是零或一，也就是已经排序好了。这个算法一定会结束，因为在每次的迭代（iteration）中，它至少会把一个元素摆到它最后的位置去。
 *
 * 时间复杂度为 Ο(nlogn)，性能比较好
 *
 * Created by Juhezi on 2017/3/18.
 */
public class QuickSort {

    public static <T> void sort(T[] array, JComparable<T> comparable, int left, int right) {
        if (comparable == null || left >= right)
            return;
        T key = array[left];
        int lo = left;
        int hi = right;
        while (lo < hi) {
            while (lo < hi && comparable.lessOrEquals(key, array[hi]))
                hi--;
            array[lo] = array[hi];
            while (lo < hi && comparable.moreOrEquals(key, array[lo]))
                lo++;
            array[hi] = array[lo];
        }
        array[lo] = key;
        sort(array, comparable, left, lo - 1);
        sort(array, comparable, lo + 1, right);
    }

    /**
     * Swaps x[a] with x[b].
     */
    private static void swap(Object[] x, int a, int b) {
        Object t = x[a];
        x[a] = x[b];
        x[b] = t;
    }

}
