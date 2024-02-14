package com.tutorial.tree.binarytree;

public class Node {
    int data;
    Node left;
    Node right;
    Node parent;

    public Node(int data){
        this.data = data;
    }

    public int getData() {
        return data;
    }
}
