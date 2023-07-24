package com.tutorial.tree.binarytree;

/**
 * Recursive DFS on a binary tree
 */

public class DepthFirstTraversalRecursive implements DepthFirstTraversal{

    private final BinaryTree tree;

    public DepthFirstTraversalRecursive(BinaryTree tree){
        this.tree = tree;
    }

    @Override
    public void traversePreOrder(NodeVisitor visitor) {
        traversePreOrder(tree.getRoot(), visitor);
    }

    /**
     * Traverses the tree in preorder and calls the NodeVisitor.visit(node) method on each node
     * @param node
     * @param visitor
     */
    public static void traversePreOrder(Node node, NodeVisitor visitor){
        if(node == null) {
            return;
        }
        visitor.visit(node);
        traversePreOrder(node.left, visitor);
        traversePreOrder(node.right, visitor);
    }

    @Override
    public void traversePostOrder(NodeVisitor visitor) {
        traversePostOrder(tree.getRoot(), visitor);
    }

    /**
     * Traverses the tree in postorder and calls NodeVisitor.visit(node) method on each node
     * @param node
     * @param visitor
     */
    public void traversePostOrder(Node node, NodeVisitor visitor){
        if(node == null){
            return;
        }
        traversePreOrder(node.left, visitor);
        traversePostOrder(node.right, visitor);
        visitor.visit(node);
    }

    @Override
    public void traverseInOrder(NodeVisitor visitor) {

    }

    /**
     * Traverses the tree in in-order and calls NodeVisitor.visit(node) method on each node
     * @param node
     * @param visitor
     */
    public void traverseInOrder(Node node, NodeVisitor visitor){
        if(node == null){
            return;
        }
        traverseInOrder(node.left, visitor);
        visitor.visit(node);
        traverseInOrder(node.right, visitor);
    }

    @Override
    public void traverseReverseInOrder(NodeVisitor visitor) {

    }
}
