package com.dsa.trees;

import java.util.HashMap;
import java.util.Map;

public class MorrisInOrder {

    final Map<Integer, TreeNode> parentMap = new HashMap<>();

    public TreeNode findMin(TreeNode treeNode) {
        while (treeNode.getLeft() != null) {
            treeNode = treeNode.getLeft();
        }
        return treeNode;
    }

    public TreeNode findMax(TreeNode node) {
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }

    public TreeNode successor(TreeNode node, TreeNode root) {
        if (node.getRight() != null) {
            return findMin(node.getRight());
        }
        else {
            return successor(node, root, null);
        }
    }

    public TreeNode successor(TreeNode root, TreeNode node, TreeNode lastNode) {
        if (root.getVal() == node.getVal()) {
            return lastNode;
        }
        else {
            if (node.getVal() < root.getVal()) {
                return successor(root.getLeft(), node, )
            }
        }
    }
}
