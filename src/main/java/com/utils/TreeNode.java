package com.utils;

public class TreeNode<V> {
    public V v;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(V v){
        this.v = v;
    }
    public TreeNode(V v, TreeNode left, TreeNode right){
        this.v = v;
        this.left = left;
        this.right = right;
    }
}
