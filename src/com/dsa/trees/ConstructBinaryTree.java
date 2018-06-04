package com.dsa.trees;

import sun.reflect.generics.tree.Tree;

/**
 * Construct Binary Tree From Inorder And Preorder
 * Given preorder and inorder traversal of a tree, construct the binary tree.

 * Note: You may assume that duplicates do not exist in the tree.
 * Example :

 * Input :
 * Preorder : [1, 2, 3]
 * Inorder  : [2, 1, 3]

 * Return :
 * 1
 * / \
 * 2   3
 * /
 * */

public class ConstructBinaryTree {

    public TreeNode buildTree(int[] A, int[] B) {

        TreeNode root = new TreeNode(A[0]);
        TreeNode lastNode = root;
        int indexOfLastRoot = indexOf(B, A[0]);

        for (int i = 1; i < A.length; i++) {
            final TreeNode currentNode = new TreeNode(A[i]);
            int indexOfCurrentRoot = indexOf(B, A[i]);

            if (indexOfCurrentRoot < indexOfLastRoot) {
                lastNode.setLeft(currentNode);
            }

            if (indexOfCurrentRoot > indexOfLastRoot) {
                lastNode.setRight(currentNode);
            }

            indexOfLastRoot = indexOfCurrentRoot;
            lastNode = currentNode;

        }

        return root;
    }

    public int indexOf(int[] B, int root) {
        for (int i = 0; i < B.length ; i++) {
            if (B[i] == root) {
                return i;
            }
        }
        return -1;
    }

}
