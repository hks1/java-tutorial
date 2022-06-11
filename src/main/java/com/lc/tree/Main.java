package com.lc.tree;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Traversal traversal = new Traversal();
        TreeNode left_node = new TreeNode(1, new TreeNode(5), new TreeNode(4));
        TreeNode right_node = new TreeNode(2, new TreeNode(9), new TreeNode(6));
        TreeNode tree = new TreeNode(7, left_node, right_node);
        List<Integer> list = traversal.preorderTraversal(tree);
        System.out.println(list.toString());

        list = traversal.inorderTraversal(tree);
        System.out.println(list.toString());

        list = traversal.postorderTwoStacks(tree);
        System.out.println(list);

        list = traversal.postorderOneStack(tree);
        System.out.println(list);

    }
}
