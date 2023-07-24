package com.tutorial.tree.binarytree;

/**
 * Interface for DFS on a binary tree
 */

// We implement the visiting during traversal using the visitor design pattern, i.e., we create a visitor object which we pass to the traversal method.

public interface DepthFirstTraversal {
    /**
     * Traverse the tree in pre-order and calls the NodeVisitor.visit(Node) method on each node
     */
    void traversePreOrder(NodeVisitor visitor);

    /**
     * Traverse the tree in post-order and calls the NodeVisitor.visit(node) method on each node
     */
    void traversePostOrder(NodeVisitor visitor);

    /**
     * Traverse the tree in-order and calls the NodeVisitor.visit(node) method on each node
     */
    void traverseInOrder(NodeVisitor visitor);

    /**
     * Traverse the tree reverse in-order and calls the NodeVisitor.visit(node) method on each node
     */
    void traverseReverseInOrder(NodeVisitor visitor);
}
