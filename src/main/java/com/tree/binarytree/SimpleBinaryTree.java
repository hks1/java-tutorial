package com.tree.binarytree;

import java.util.Objects;

public class SimpleBinaryTree extends BaseBinaryTree{

    /** Indicates the child position (left, right) when inserting a node. */
    public enum Side{
        LEFT,
        RIGHT
    }

    /**
     *
     * @param value
     * @return
     */
    public Node insertRoot(int value){
        if(root != null){
            throw new IllegalStateException("Root already defined");
        }

        root = new Node(value);

        return root;
    }

    /**
     *
     * @param value
     * @param parent
     * @param side
     * @return
     */
    public Node insertNode(int value, Node parent, Side side){
        Objects.requireNonNull(parent);
        var node = new Node(value);

        node.parent = parent;

        switch (side) {
            case LEFT -> {
                if(parent.left != null){
                    node.left = parent.left;
                    node.left.parent = node;
                }
                parent.left = node;
            }

            case RIGHT -> {
                if(parent.right != null){
                    node.right = parent.right;
                    node.right.parent = node;
                }
                parent.right = node;
            }

            default -> throw new IllegalStateException();
        }

        return node;
    }

    /**
     *
     * @param node
     */
    public void deleteNode(Node node){
        if(node.parent == null && node != root){
            throw new IllegalStateException("Node has no parent and is not root");
        }

        // Case A: Node has no children -> set node parent to null
        if(node.left == null && node.right == null){
            //
        }
    }
}
