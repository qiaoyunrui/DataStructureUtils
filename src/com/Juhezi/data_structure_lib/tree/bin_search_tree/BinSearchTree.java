package com.juhezi.data_structure_lib.tree.bin_search_tree;

import com.juhezi.data_structure_lib.tree.bin_tree.BinTree;
import com.juhezi.data_structure_lib.tree.bin_tree.Node;
import com.juhezi.data_structure_lib.util.JComparable;

/**
 * 二叉查找树
 * Created by qiao1 on 2017/2/15.
 */
public class BinSearchTree<T> extends BinTree<T> {
    private static String TAG = "BinSearchTree";

    public Node<T> search(T key, JComparable<T> comparable) {
        return partSearch(root, key, comparable);
    }

    /**
     * 递归查找
     *
     * @param node
     * @param key
     * @param comparable
     * @return
     */
    private Node<T> partSearch(Node<T> node, T key, JComparable<T> comparable) {
        if (node == null) return null;
        if (comparable.equals(key, node.getValue())) return node;
        if (comparable.lessThan(key, node.getValue()))
            return partSearch(node.getLeftChild(), key, comparable);
        else return partSearch(node.getRightChild(), key, comparable);
    }

    /**
     * 迭代查找
     *
     * @param node
     * @param key
     * @param comparable
     * @return
     */
    private Node<T> partSearch2(Node<T> node, T key, JComparable<T> comparable) {
        while (node != null) {
            if (comparable.equals(key, node.getValue())) return node;
            if (comparable.lessThan(key, node.getValue())) node = node.getLeftChild();
            else node = node.getRightChild();
        }
        return null;
    }

    /**
     * 如果树为空，则返回null
     * 如果找到该key所对应的Node，则返回null
     * 如果没有找到，则返回查找过程中所遇到的树中最后一个结点
     *
     * @param key
     * @param comparable
     * @return
     */
    private Node<T> modifiedSearch(T key, JComparable<T> comparable) {
        if (root == null) return null;
        Node<T> node = root;
        Node<T> parent = null;
        while (node != null) {
            if (comparable.equals(key, node.getValue())) return null;   //找到了
            parent = node;
            if (comparable.lessThan(key, node.getValue())) {
                node = node.getLeftChild();
            } else {
                node = node.getRightChild();
            }
        }
        return parent;
    }

    /**
     * 时间复杂度为O(n)
     *
     * @param key
     * @param comparable
     * @return
     */

    public boolean insert(T key, JComparable<T> comparable) {
        if (key == null)
            throw new NullPointerException("The key can not be null!");
        Node<T> temp = modifiedSearch(key, comparable);
        if (temp != null || root == null) {  //没有找到相同的或者根节点是空的
            Node<T> node = new Node<T>(key);
            if (root != null) {
                if (comparable.lessThan(key, temp.getValue())) {
                    temp.setLeftChild(node);
                    node.setParent(temp);
                } else {
                    temp.setRightChild(node);
                    node.setParent(temp);
                }
            } else {
                root = node;
            }
            return true;
        }
        return false;
    }

    /**
     * 删除
     *
     * @param key
     * @param comparable
     * @return
     */
    public boolean delete(T key, JComparable comparable) {
        Node<T> node = search(key, comparable);
        if (node == null) return false;
        if (node.getLeftChild() == null)
            transPlant(node, node.getRightChild());
        else if (node.getRightChild() == null)
            transPlant(node, node.getLeftChild());
        else {
            Node<T> temp = getMinKey(node.getRightChild());     //寻找后继结点
            if (temp.getParent() != node) {
                transPlant(temp, temp.getRightChild());
                temp.setRightChild(node.getRightChild());
                temp.getRightChild().setParent(temp);
            }
            transPlant(node, temp);
            temp.setLeftChild(node.getLeftChild());
            temp.getLeftChild().setParent(temp);
        }
        return true;
    }

    /**
     * 用一棵子树替换一棵子树并成为其双亲的孩子结点。
     */
    private void transPlant(Node<T> nodeu, Node<T> nodev) {
        if (nodeu.getParent() == null)
            root = nodev;
        else if (nodeu == nodeu.getParent().getLeftChild())
            nodeu.getParent().setLeftChild(nodev);
        else
            nodeu.getParent().setRightChild(nodev);
        if (nodev != null)
            nodev.setParent(nodeu.getParent());
    }

    /**
     * 获取最大值
     *
     * @return
     */
    public Node<T> getMaxKey(Node<T> node) {
        if (node == null) return null;
        while (node.getRightChild() != null)
            node = node.getRightChild();
        return node;
    }

    /**
     * 获取最小值
     *
     * @return
     */
    public Node<T> getMinKey(Node<T> node) {
        if (node == null) return null;
        while (node.getLeftChild() != null)
            node = node.getLeftChild();
        return node;
    }

}
