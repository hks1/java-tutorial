package com.tutorial.bstiterator;

import com.utils.TreeNode;

public class BSTIteratorTestDrive {
    public static void main(String[] args) {
        TreeNode<Integer> left = new TreeNode<>(2, new TreeNode(4), new TreeNode(5));
        TreeNode<Integer> right = new TreeNode<>(6, new TreeNode(7), new TreeNode(8));
        TreeNode<Integer> root = new TreeNode<>(9, left, right);
        BSTIterator bstIterator = new BSTIterator(root);
        while(bstIterator.hasNext()){
            System.out.println(bstIterator.next());
        }
    }
}
