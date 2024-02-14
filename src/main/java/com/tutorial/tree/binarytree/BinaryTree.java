package com.tutorial.tree.binarytree;

public interface BinaryTree {
    Node getRoot();

}

// notes
// https://www.happycoders.eu/algorithms/binary-tree-java/
// https://github.com/SvenWoltmann/binary-tree
// A node with only one child is a half node. Attention: this term exists – in contrast to all others – only for binary trees, not for trees in general.
//The number of child nodes is also called the degree of a node.
//The depth of a node indicates how many levels the node is away from the root. Therefore, the root has a depth of 0, the root's children have a depth of 1, and so on.
//The height of a binary tree is the maximum depth of all its nodes.

//  full binary tree -  all nodes have either no children or two children.
// In a complete binary tree, all levels, except possibly the last one, are completely filled. If the last level is not completely filled, then its nodes are arranged as far to the left as possible.
// A perfect binary tree is a full binary tree in which all leaves have the same depth. A perfect binary tree of height h has n = 2h+1-1 nodes and l = 2h leaves.
// In a balanced binary tree, each node's left and right subtrees differ in height by at most one.
// In a sorted binary tree (also known as ordered binary tree), the left subtree of a node contains only values less than (or equal to) the value of the parent node, and the right subtree contains only values greater than (or equal to) the value of the parent node. Such a data structure is also called a binary search tree.

// other resources - move these to appropriate files
//https://www.happycoders.eu/algorithms/heapsort/#What_is_a_Heap
// https://www.happycoders.eu/algorithms/java-stack-class/#why-you-should-not-use-stack-anymore
// https://www.happycoders.eu/java/switch-expression/


