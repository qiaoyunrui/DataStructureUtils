package com.juhezi.data_structure_lib.tree;

import com.juhezi.data_structure_lib.util.Action;

import java.awt.Font;

/**
 * 二叉树
 * <p>
 * Created by qiao1 on 2017/2/5.
 */
public class BinTree<T> {
    private static String TAG = "BinTree";

    private static final int FRONT = 0x101;
    private static final int CENTER = 0x102;
    private static final int BEHIND = 0x103;
    private static final int LEVEL = 0x124;

    private int size = -1;
    private Node<T> root = null;   //根节点

    /**
     * 创建一个空的二叉树
     */
    public BinTree() {
        size = 0;
    }

    public BinTree(Node<T> root) {
        this.root = root;
        calculateSize();
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
        if (rootNode == null) return null;
        BinTree<Type> result = new BinTree<>(rootNode);
        if (leftBinTree == null) {
            rootNode.setLeftChild(null);
        } else {
            rootNode.setLeftChild(leftBinTree.getRoot());
            leftBinTree.getRoot().setParent(rootNode);
        }
        if (rightBinTree == null) {
            rootNode.setRightChild(null);
        } else {
            rootNode.setRightChild(rightBinTree.getRoot());
            rightBinTree.getRoot().setParent(rootNode);
        }
        return result;
    }

    /**
     * 获取左子树
     *
     * @return
     */
    public BinTree<T> getLeftChild() {
        if (root != null) {
            return new BinTree<>(root.getLeftChild());
        }
        return null;
    }

    /**
     * 获取右子树
     *
     * @return
     */
    public BinTree<T> getRightChild() {
        if (root != null) {
            return new BinTree<>(root.getRightChild());
        }
        return null;
    }

    /**
     * 打印该二叉树
     *
     * @return
     */
    @Override
    public String toString() {
        // TODO: 2017/2/9  
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
        // TODO: 2017/2/9  
        return super.clone();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null)
            return false;
        if (o instanceof BinTree)
            return equals(root, ((BinTree) o).root);
        if (o instanceof Node)
            return equals(root, (Node) o);
        return false;
    }

    /**
     * 递归判断两个结点是否相等
     *
     * @param var1
     * @param var2
     * @return
     */
    private static boolean equals(Node var1, Node var2) {
        return ((var1 == null) && (var2 == null)) ||
                ((var1 != null)
                        && (var2 != null)
                        && (var1.getValue() == var2.getValue())
                        && equals(var1.getLeftChild(), var1.getLeftChild())
                        && equals(var1.getRightChild(), var2.getRightChild()));
    }

    public void clear() {
        //要进行垃圾回收
        size = 0;
        traverse(root, new Action<Node>() {
            @Override
            public void onAction(Node node) {
                node = null;
            }
        });
    }

    /**
     * 遍历操作
     */
    public void forEach(int type, Action<T> action) {
        switch (type) {
            case FRONT:
                preOrder(root, action);
                break;
            case CENTER:
                inOrder(root, action);
                break;
            case BEHIND:
                postOrder(root, action);
                break;
            case LEVEL:
                break;
            default:
                preOrder(root, action);
        }
    }

    /**
     * 层序遍历
     *
     * @param node
     * @param action
     */
    private void levelOrder(Node<T> node, Action<T> action) {
        // TODO: 2017/2/9 complete
    }

    /**
     * 遍历
     *
     * @param node
     * @param action
     */
    private void traverse(Node<T> node, Action<Node> action) {
        if (node != null) {
            traverse(node.getLeftChild(), action);
            traverse(node.getRightChild(), action);
            action.onAction(node);
        }
    }

    /**
     * 前序遍历
     */
    private void preOrder(Node<T> node, Action<T> action) {
        if (node != null) {
            action.onAction(node.getValue());
            preOrder(node.getLeftChild(), action);
            preOrder(node.getRightChild(), action);
        }
    }

    /**
     * 中序遍历
     */
    private void inOrder(Node<T> node, Action<T> action) {
        if (node != null) {
            inOrder(node.getLeftChild(), action);
            action.onAction(node.getValue());
            inOrder(node.getRightChild(), action);
        }
    }

    /**
     * 后续遍历
     */
    private void postOrder(Node<T> node, Action<T> action) {
        if (node != null) {
            postOrder(node.getLeftChild(), action);
            postOrder(node.getRightChild(), action);
            action.onAction(node.getValue());
        }
    }

    /**
     * 获取结点的数量
     *
     * @return
     */
    public int getSize() {
        if (size < 0) {
            calculateSize();
        }
        return size;
    }

    /**
     * 计算该树的高度
     */
    private void calculateSize() {
        size = 0;
        forEach(FRONT, new Action<T>() {
            @Override
            public void onAction(T t) {
                size++;
            }
        });
    }

    public Node<T> getRoot() {
        return root;
    }

    public void setRoot(Node<T> root) {
        this.root = root;
    }
}
