package com.lc.tree;

import javax.swing.tree.TreeCellRenderer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Traversal {
    /**
     * preorder traversal
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root){
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

    /**
     * postorder traversal with 2 stacks
     * @param root
     * @return
     */
    public List<Integer> postorderTwoStacks(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (s1.size() > 0){
            TreeNode node = s1.pop();
            s2.push(node);
            if(node.left != null){
                s1.push(node.left);
            }
            if(node.right != null){
                s1.push(node.right);
            }
        }
        while(s2.size() > 0){
            result.add(s2.pop().val);
        }
        return result;
    }

    public List<Integer> postorderOneStack(TreeNode root){
        List<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            if(curr != null){
                stack.push(curr);
                curr = curr.left;
            }else{
                TreeNode temp = stack.peek().right;
                if(temp == null){
                    temp = stack.pop();
                    result.add(temp.val);
                    while (!stack.isEmpty() && temp == stack.peek().right){
                        temp = stack.pop();
                        result.add(temp.val);
                    }
                }else{
                    curr = temp;
                }
            }
        }
        return result;
    }

    /**
     * inorder traversal
     * @param root
     * @return
     */
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        //stack.push(root);
        while(root != null || stack.size() > 0){
            if(root != null){
                stack.push(root);
                root = root.left;
            }else{
                root = stack.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }
}
