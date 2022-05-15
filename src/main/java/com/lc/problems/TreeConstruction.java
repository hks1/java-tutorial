package com.lc.problems;

import com.lc.tree.Tree;
import com.lc.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class TreeConstruction {
    /**
     * 106. Construct Binary Tree from Inorder and Postorder Traversal
     * Given two integer arrays inorder and postorder where inorder is the inorder traversal of a binary tree and postorder is the postorder traversal of the same tree, construct and return the binary tree.
     */
    Map<Integer, Integer> inorderMap = new HashMap<>();
    Map<Integer, Integer> postorderMap = new HashMap<>();
    public TreeNode createTree(int[] inorder, int[] postorder){
        if(inorder.length == 0 || inorder.length != postorder.length){
            return null;
        }
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
            postorderMap.put(postorder[i], i);
        }
        return createTreeHelper(inorder, 0, inorder.length-1,
                postorder, 0, postorder.length-1);
    }

    public TreeNode createTreeHelper(int[] inorder, int iStart, int iEnd,
                                     int[] postorder, int pStart, int pEnd){
        // base case
        if(iStart > iEnd || pStart > pEnd){
            return null;
        }
        if(iStart == iEnd && pStart == pEnd){
            return new TreeNode(inorder[iStart]);
        }
        // root
        TreeNode root = new TreeNode(postorder[pEnd]);
        //root index in inorder
        int rootIndex = inorderMap.get(postorder[pEnd]);
        if(rootIndex > 0){
            int pEndNew = postorderMap.get(inorder[rootIndex-1]);
            root.left = createTreeHelper(inorder, iStart, rootIndex-1,
                    postorder, pStart, pEndNew);
        }
        if(rootIndex < inorder.length-1){
            // pStartNew - new pStart value to build right subtree
            int pStartNew = postorderMap.get(inorder[rootIndex+1]);
            root.right = createTreeHelper(inorder, rootIndex+1, iEnd,
                    postorder, pStartNew, pEnd-1);
        }

        return root;
    }
}

class TDTreeConstruction{
    public static void main(String[] args) {
        TreeConstruction obj = new TreeConstruction();
        int[] inorder = new int[]{9,3,15,20,7};
        int[] postorder = new int[]{9,15,7,20,3};
        TreeNode root = obj.createTree(inorder, postorder);
        TreeNode root1 = obj.createTree(new int[]{1,2}, new int[]{2,1});
        System.out.println(com.lc.tree.Traversal.preorderTraversal(root1));
        //TreeNode root2 = obj.createTree(new int[]{2,1}, new int[]{2,1});
        //System.out.println(com.lc.tree.Traversal.preorderTraversal(root2));

        //System.out.println(com.lc.tree.Traversal.preorderTraversal(root));
    }
}
