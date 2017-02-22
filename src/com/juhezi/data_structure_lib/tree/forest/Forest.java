package com.juhezi.data_structure_lib.tree.forest;

import com.juhezi.data_structure_lib.tree.bin_tree.BinTree;
import com.juhezi.data_structure_lib.tree.bin_tree.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by qiao1 on 2017/2/22.
 */
public class Forest<T> {

    /**
     * 树的结点，并不是二叉树
     *
     * @param <T>
     */
    public class TreeNode<T> {
        public T value;
        public TreeNode<T> parent;  //父结点
        public List<TreeNode<T>> childs = new LinkedList<>();  //子结点，数量不确定
    }

    public Forest(List<TreeNode<T>> trees) {
        if (trees != null)
            this.trees = trees;
    }

    private List<TreeNode<T>> trees = new LinkedList<>();   //树的集合

    public boolean isEmpty() {
        return trees.isEmpty();
    }

    public boolean add(TreeNode<T> tree) {
        return trees.add(tree);
    }

    public void add(int position, TreeNode<T> tree) {
        trees.add(position, tree);
    }

    public TreeNode<T> remove(int position) {
        return trees.remove(position);
    }

    public boolean remove(TreeNode<T> tree) {
        return trees.remove(tree);
    }

    public void clear() {
        trees.clear();
    }

    public int size() {
        return trees.size();
    }

    /**
     * 森林转换为二叉树
     *
     * @return
     */
    public BinTree<T> toBinTree() {
        if (size() == 0) return null;
        BinTree<T> binTree = new BinTree<>();
        Node<T> root = new Node<>(trees.get(0).value);    //根为森林中第一棵树的根
        root.setLeftChild(new Forest<T>(trees.get(0).childs).toBinTree().getRoot());
        trees.remove(0);
        root.setRightChild(toBinTree().getRoot());
        binTree.setRoot(root);  //根为第一棵树的根
        return binTree;
    }

}
