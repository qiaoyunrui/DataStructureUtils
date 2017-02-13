package com.juhezi.data_structure_lib.sort;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * <p>
 * Created by qiao1 on 2017/2/13.
 */
public class InsertSort {
    private static String TAG = "InsertSort";

    /**
     * 插入排序
     *
     * @param array      要排序的数组
     * @param comparable
     * @param <T>
     */
    public static <T> void sort(T[] array, JComparable<T> comparable) {
        if (comparable == null) {
            throw new NullPointerException("comparable can not be null!!");
        }
        int len = array.length;
        int i;
        T key;
        for (int j = 1; j < len; j++) {
            key = array[j];
            i = j - 1;
            while (i >= 0 && comparable.moreThan(array[i], key)) {
                array[i + 1] = array[i];    //向后移一位
                i = i - 1;
            }
            array[i + 1] = key;     //把key放在空缺的位置
        }

    }

}
