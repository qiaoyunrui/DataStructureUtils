package com.juhezi.data_structure_lib.tree.colleaction;

import java.util.Arrays;

/**
 * Created by qiao1 on 2017/2/28.
 */
public class Collection<T> {

    private static final int MAX_ELEMENTS = 1024;

    private int[] parent;   //存放父节点所在的位置
    private T[] values;
    private int size = 0;

    public Collection() {
    }

    public Collection(T[] values, int[] parent) {
        setData(values, parent);
    }

    public void setData(T[] values, int[] parent) {
        if (parent == null || values == null) return;
        int differ = parent.length - values.length;
        if (differ > 0) {   //parent较长
            parent = Arrays.copyOf(parent, values.length);
        }
        if (differ < 0) {
            values = Arrays.copyOf(values, parent.length);
        }
        this.parent = parent;
        this.values = values;
        this.size = parent.length;
    }

    /**
     * 寻找index所对应的结点所在的树
     *
     * @param index
     * @return
     */
    public int find(int index) {
        if (index >= size) return -1;
        for (; parent[index] >= 0; index = parent[index])
            ;
        return index;
    }

    public int findX(int index) {
        int root, trail, lead;
        for (root = index; parent[root] >= 0; root = parent[root])
            ;
        for (trail = index; trail != root; trail = lead) {  //把index到根节点之间所有结点的父节点设为根节点。
            lead = parent[trail];
            parent[trail] = root;
        }
        return root;
    }

    /**
     * 并操作，把第一棵树作为第二棵树的子树
     *
     * @param i
     * @param j
     */
    public void union(int i, int j) {
        //i,j必须是树根
        if (parent[i] == -1 || parent[j] == -1) return;
        parent[i] = j;
    }

}