package com.juhezi.data_structure_lib.tree.threaded_tree;

/**
 * 线索二叉树结点
 * <p>
 * Created by qiao1 on 2017/2/14.
 */
public class ThreadedNode<T> {

    T value;
    boolean leftThread;     //左子树是否为一个线索
    ThreadedNode<T> leftChild;
    boolean rightThread;    //右子树是否为一个线索
    ThreadedNode<T> rightChild;

    /**
     * 为本结点插入子节点
     *
     * @param child
     * @param isLeftChild
     */
    public void insert(ThreadedNode<T> child, boolean isLeftChild) {
        ThreadedNode<T> temp;
        if (isLeftChild) {  //作为左结点
            child.leftThread = leftThread;
            child.leftChild = leftChild;
            child.rightChild = this;
            child.rightThread = true;
            leftChild = child;
            leftThread = false;
            if (!child.leftThread) {
                temp = child.inpre();
                temp.rightChild = child;
            }

        } else {    //作为右结点
            child.rightChild = rightChild;
            child.rightThread = rightThread;
            child.leftChild = this;
            child.leftThread = true;
            rightChild = child;
            rightThread = false;
            if (!child.rightThread) {    //如果子结点的右字数不是线索，即父节点原来的右子树不是线索
                temp = child.insucc();
                temp.leftChild = child;
            }
        }
    }

    /**
     * 找到本结点的中序后继结点
     *
     * @return
     */
    ThreadedNode<T> insucc() {
        ThreadedNode<T> temp;
        temp = rightChild;
        if (!rightThread) { //右子树不是线索
            while (!temp.leftThread) {   //当左子树不是线索时一直沿着左子树链向下寻找
                temp = leftChild;
            }
        }
        return temp;
    }

    /**
     * 找到本结点的中序前驱结点
     *
     * @return
     */
    ThreadedNode<T> inpre() {
        ThreadedNode<T> temp;
        temp = leftChild;
        if (!leftThread) {
            while (!temp.rightThread) {
                temp = rightChild;
            }
        }
        return temp;
    }

}
