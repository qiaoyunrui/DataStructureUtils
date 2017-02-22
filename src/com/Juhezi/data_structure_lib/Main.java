package com.juhezi.data_structure_lib;

import com.juhezi.data_structure_lib.heap.Heap;
import com.juhezi.data_structure_lib.heap.MaxHeap;
import com.juhezi.data_structure_lib.heap.MinHeap;
import com.juhezi.data_structure_lib.sort.InsertSort;
import com.juhezi.data_structure_lib.sort.MergeSort;
import com.juhezi.data_structure_lib.util.JComparable;
import com.juhezi.data_structure_lib.util.impl.IntegerComparable;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class Main {
    private static String TAG = "Main";

    public static void main(String[] args) {
        System.out.println(fun1(25));
    }

    public static void fun(int index) {
        BigInteger bigInteger = new BigInteger(index + "");
        BigInteger result = new BigInteger("1");
        BigInteger offset = new BigInteger("-1");
        while (index > 0) {
            result = result.multiply(bigInteger);
            bigInteger = bigInteger.add(offset);
            index--;
        }
        System.out.println(result);
    }

    public static int fun1(int index) {
        int result = 0;
        int len = 1;
        while (len <= index) {
            len *= 5;
            result += index / len;
        }
        return result;
    }

}
