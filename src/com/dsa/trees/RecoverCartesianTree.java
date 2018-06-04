package com.dsa.trees;


import java.util.Arrays;

/**
 * Given an inorder traversal of a cartesian tree, construct the tree.
 *
 * Cartesian tree : is a heap ordered binary tree, where the root is greater than all the elements in the subtree.
 * Note: You may assume that duplicates do not exist in the tree.
 * Example :

 * Input : [1 2 3]

 * Return :
 *      3
 *     /
 *    2
 *   /
 *  1
 *
 */
public class RecoverCartesianTree {

    public TreeNode buildTree(int[] inOrderList, int startIndex, int endIndex) {

        int maxElementIndex = this.getIndexOfMaxElement(inOrderList, startIndex, endIndex);
        TreeNode root = new TreeNode(inOrderList[maxElementIndex]);

        if (startIndex <= maxElementIndex - 1) {
            TreeNode leftChild = this.buildTree(inOrderList, startIndex, maxElementIndex - 1);
            root.setLeft(leftChild);
        }

        if (maxElementIndex + 1 <= endIndex) {
            TreeNode rightChild = this.buildTree(inOrderList, maxElementIndex + 1, endIndex);
            root.setRight(rightChild);
        }

        return root;
    }

    public int getIndexOfMaxElement(int[] arr, int startIndex, int endIndex) {
        int max = -99;
        int maxIndex = -99;
        for (int i = startIndex; i <= endIndex ; i++) {
            if (arr[i] > max) {
                max = arr[i];
                maxIndex = i;
            }
        }

        return maxIndex;
    }
}
