package com.juhezi.data_structure_lib.sort;

import com.juhezi.data_structure_lib.util.JComparable;

import java.util.Arrays;

/**
 * 快速排序'
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
