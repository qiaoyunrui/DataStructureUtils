package com.juhezi.data_structure_lib;

import com.juhezi.data_structure_lib.sort.InsertSort;
import com.juhezi.data_structure_lib.sort.MergeSort;
import com.juhezi.data_structure_lib.util.impl.IntegerComparable;

import java.util.Arrays;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class Main {
    private static String TAG = "Main";

    public static void main(String[] args) {
        Integer[] array = new Integer[]{5, 2, 4, 6, 1, 3};
        Integer[] dest = new Integer[6];
        MergeSort.sort(array, dest, new IntegerComparable());
        for (int i = 0; i < dest.length; i++) {
            System.out.print(dest[i] + "\t");
        }
    }

}
