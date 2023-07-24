package com.tutorial.tree.binarytree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Iterative breadth-first (BFS) traversal on a binary tree
 */

public class BreadthFirstTraversal {

    private final BinaryTree tree;

    public BreadthFirstTraversal(BinaryTree tree){
        this.tree = tree;
    }

    /**
     * Traverses the tree level-order and calls the NodeVisitor.visit(node) method on each node
     */
    public void traversalLevelOrder(NodeVisitor visitor){
        traverseLevelOrder(this.tree.getRoot(), visitor);
    }

    /**
     * Traverses the tree level-order and calls the NodeVisitor.visit(node) method on each node
     * @param root
     * @param visitor
     */
    public static void traverseLevelOrder(Node root, NodeVisitor visitor){
        if(root == null){
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            visitor.visit(node);

            if(node.left != null){
                queue.add(node.left);
            }
            if(node.right != null){
                queue.add(node.right);
            }
        }
    }
}
