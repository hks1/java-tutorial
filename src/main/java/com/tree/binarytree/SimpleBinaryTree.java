package com.tree.binarytree;

public class SimpleBinaryTree extends BaseBinaryTree{

    public Node insertRoot(int value){
        if(root != null){
            throw new IllegalStateException("Root already defined");
        }

        root = new Node(value);

        return root;
    }
}
