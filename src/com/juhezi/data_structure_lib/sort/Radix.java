package com.juhezi.data_structure_lib.sort;

/**
 * Created by Juhezi on 2017/4/9.
 */
public class Radix {

    private static final int MAX_DIGIT = 3;
    private static final int RADIX_SIZE = 10;   //基数

    static class Node {
        Node link;
        int[] key = new int[MAX_DIGIT];
    }


    //LSD
    public Node radixNode(Node ptr) {
        Node[] front = new Node[RADIX_SIZE];
        Node[] rear = new Node[RADIX_SIZE];
        int digit;
        for (int i = MAX_DIGIT; i >= 0; i--) {
            while (ptr != null) {
                digit = ptr.key[i];
                if (front[digit] == null) {
                    front[digit] = ptr;
                } else {
                    rear[digit].link = ptr;
                }
                rear[digit] = ptr;
                ptr = ptr.link;
            }
            ptr = null;
            for (int j = RADIX_SIZE - 1; j >= 0; j--) {
                if (front[j] != null) {
                    rear[j].link = ptr;
                    ptr = front[j];
                }
            }
        }
        return ptr;
    }

}
