package com.bstiterator;

import com.utils.TreeNode;

import java.util.Stack;

public class BSTIterator<V> {
    Stack<TreeNode<V>> s;
    BSTIterator(TreeNode<V> root){
        s = new Stack<>();
        TreeNode<V> curr = root;
        while(curr != null){
            s.push(curr);
            curr = curr.left;
        }
    }

    public boolean hasNext(){
        return s.size() > 0;
    }

    public V next(){
        TreeNode<V> temp = s.peek().right;
        V v = s.pop().v;
        while (temp != null){
            s.push(temp);
            temp = temp.left;
        }
        return v;
    }
}
