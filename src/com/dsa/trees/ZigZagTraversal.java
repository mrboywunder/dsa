package com.dsa.trees;

import java.util.*;

public class ZigZagTraversal {

    List<List<Integer>> levelOrderMap = new ArrayList<>(3);
//    List<List<Integer>> levelOrderMap = new ArrayList<>(3);

    final Map<Integer, Boolean> traversalDirection = new HashMap<>();

    int height = 0;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        levelOrderMap.add(new ArrayList<>());
        levelOrderMap.add(new ArrayList<>());
        levelOrderMap.add(new ArrayList<>());
        this.levelOrder(root);
        return levelOrderMap;
    }

    public int height(TreeNode node) {
        if (node == null) {
            return -1;
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }

        return 1 + Math.max(height(node.getLeft()), height(node.getRight()));
    }

    public void levelOrder(TreeNode node) {
        height = height(node);
        boolean orderSwitch = true;
        for (int i = height; i >= 0; i--) {
            traversalDirection.put(i, orderSwitch);
            orderSwitch = !orderSwitch;
        }
        traverse(node, height);
    }

    public void traverse(TreeNode node, int height) {

        if (node == null) {
            return;
        }

        List<Integer> nodesAtLevel = levelOrderMap.get(height);
        nodesAtLevel.add(node.getVal());

        if (!traversalDirection.get(height)) {
            traverse(node.getLeft(), height -1);
            traverse(node.getRight(), height - 1);
        }
        else {
            traverse(node.getRight(), height - 1);
            traverse(node.getLeft(), height -1);
        }

    }


}
