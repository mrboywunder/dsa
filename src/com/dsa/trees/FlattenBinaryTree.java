package com.dsa.trees;

//TODO:: Try again and Redo
public class FlattenBinaryTree {

    public TreeNode flatten(TreeNode node) {

        if (node == null) {
            return null;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return node;
        }

        TreeNode leftMostLastNode = flatten(node.getLeft());
        TreeNode rightMostLastNode = flatten(node.getRight());

        if (leftMostLastNode == null) {
            return rightMostLastNode;
        }

        if (rightMostLastNode == null) {
            return leftMostLastNode;
        }

        TreeNode leftTemp = node.getLeft();
        node.setLeft(null);
        TreeNode temp = node.getRight();
        node.setRight(leftTemp);
        leftMostLastNode.setRight(temp);

        return rightMostLastNode;
    }
}
