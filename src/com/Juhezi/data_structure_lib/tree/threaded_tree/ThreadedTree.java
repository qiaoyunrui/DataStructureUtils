package com.juhezi.data_structure_lib.tree.threaded_tree;

import com.juhezi.data_structure_lib.util.Action;

/**
 * 线索二叉树
 * 每个线索二叉树都有一个空结点
 * <p>
 * Created by qiao1 on 2017/2/14.
 */
public class ThreadedTree<T> extends ThreadedNode<T> {
    private static String TAG = "ThreadedTree";
    private ThreadedNode<T> root = this;    //根节点，值为空

    //空的线索二叉树
    public ThreadedTree() {
        //使不确定的空线索指向根节点root
        value = null;
        leftThread = true;
        leftChild = this;
        rightThread = false;
        rightChild = this;
    }


    /**
     * 中序遍历
     * O(n)
     *
     * @param action
     */
    public void inOrder(Action<T> action) {
        ThreadedNode<T> temp = root;
        while (true) {
            temp = temp.insucc();
            if (temp == root) break;
            action.onAction(temp.value);
        }
    }


}
