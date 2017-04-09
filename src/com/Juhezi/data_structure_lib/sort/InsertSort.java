package com.juhezi.data_structure_lib.sort;

import com.juhezi.data_structure_lib.util.JComparable;

/**
 * 插入排序
 * 工作原理：通过构建有序序列，对于未排序数据，在已排序序列中从后向前扫描，找到相应位置并插入。
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
    public static <T> T[] sort(T[] array, JComparable<T> comparable) {
        if (comparable == null) {
            throw new NullPointerException("comparable can not be null!!");
        }
        int len = array.length;
        int i;
        T key;
        for (int j = 1; j < len; j++) {
            key = array[j];
            i = j - 1;
            while (i >= 0 && comparable.moreThan(array[i], key)) {  //从后向前扫描，知道相应位置并插入
                array[i + 1] = array[i];    //向后移一位
                i = i - 1;
            }
            array[i + 1] = key;     //把key放在空缺的位置
        }
        return array;
    }

}
