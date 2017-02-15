package com.juhezi.data_structure_lib;

import com.juhezi.data_structure_lib.heap.Heap;
import com.juhezi.data_structure_lib.heap.MaxHeap;
import com.juhezi.data_structure_lib.heap.MinHeap;
import com.juhezi.data_structure_lib.sort.InsertSort;
import com.juhezi.data_structure_lib.sort.MergeSort;
import com.juhezi.data_structure_lib.util.JComparable;
import com.juhezi.data_structure_lib.util.impl.IntegerComparable;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by qiao1 on 2017/2/13.
 */
public class Main {
    private static String TAG = "Main";

    public static void main(String[] args) {
        Heap<Integer> heap = new MinHeap<>(10);
        JComparable comparable = new IntegerComparable();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            heap.insert(new Heap.Node<Integer>(i), comparable);
        }
    }

}
