package com.juhezi.data_structure_lib.tree;

/**
 * 二叉树
 * <p>
 * Created by qiao1 on 2017/2/5.
 */
public class BinTree<T> extends Node<T> {
    private static String TAG = "BinTree";

    private static final int FRONT = 0x101;
    private static final int CENTER = 0x102;
    private static final int BEHIND = 0x103;

    @IntDef
    public @interface TraversalType {}

    private int size;

    /**
     * 创建一个空的二叉树
     */
    public BinTree() {
        size = 0;
    }

    /**
     * 二叉树是否为空
     *
     * @return 是否为空
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * @param leftBinTree  左子树
     * @param rootNode     根结点
     * @param rightBinTree 右子树
     * @param <Type>       二叉树中存放数据的类型
     * @return 合并后的二叉树
     */
    public static <Type> BinTree<Type> makeBinTree(
            BinTree<Type> leftBinTree, Node<Type> rootNode, BinTree<Type> rightBinTree) {
        return null;
    }

    /**
     * 获取左子树
     *
     * @return
     */
    public BinTree<T> getLeftChild() {
        return (BinTree<T>) leftChild;
    }

    /**
     * 获取右子树
     *
     * @return
     */
    public BinTree<T> getRightChild() {
        return (BinTree<T>) rightChild;
    }

    /**
     * 打印该二叉树
     *
     * @return
     */
    @Override
    public String toString() {
        return super.toString();
    }

    /**
     * 克隆二叉树
     *
     * @return
     * @throws CloneNotSupportedException
     */
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    public void add(T value) {

    }

    public void remove(T value) {

    }

    public void clear() {

    }

    /**
     * 遍历操作
     */
    public void forEach(int type) {

    }

}
