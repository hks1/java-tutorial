package com.lc.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    public static List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current;
        if(root != null){
            stack.push(root);
        }
        while (!stack.empty()){
            current = stack.pop();
            if(current.right != null){
                stack.push(current.right);
            }
            if(current.left != null){
                stack.push(current.left);
            }

            list.add(current.val);
        }
        return list;
    }

    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        return list;
    }
}
