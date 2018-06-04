package com.dsa.trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Least Common Ancestor
 * Find the lowest common ancestor in an unordered binary tree given two values in the tree.

 * Lowest common ancestor : the lowest common ancestor (LCA) of two nodes v and w in a tree or directed acyclic graph (DAG) is the lowest (i.e. deepest) node that has both v and w as descendants.
 * Example :


 *          _______3______
 *          /              \
 *     ___ 5__          ___1__
 *    /      \         /      \
 *   6      _2_       0        8
 *  / \
 * 7  4
 * For the above tree, the LCA of nodes 5 and 1 is 3.

 * LCA = Lowest common ancestor
 * Please note that LCA for nodes 5 and 4 is 5.

 * You are given 2 values. Find the lowest common ancestor of the two nodes represented by val1 and val2
 * No guarantee that val1 and val2 exist in the tree. If one value doesn’t exist in the tree then return -1.
 * There are no duplicate values.
 * You can use extra memory, helper functions, and can modify the node struct but, you can’t add a parent pointer.
 *
 */
public class LowestCommonAncestor {

    final Map<Integer, List<TreeNode>> levelOrderMap = new HashMap<>();
    final Map<Integer, Integer> nodeHeightMap = new HashMap<>();
    TreeNode BNode, CNode;

    public int lca(TreeNode root, int B, int C) {
        if (root == null) {
            return 0;
        }

        int height = this.height(root);
        this.levelOrderTraversal(root, B, C);
        Integer BLevel = this.nodeHeightMap.get(B);
        Integer CLevel = this.nodeHeightMap.get(C);

        if (BLevel == null || CLevel == null) {
            return -1;
        }

        if (BLevel > CLevel) {
            if (isParentOf(BNode, C)) {
                return B;
            }
            else {
                //Look at levels above
                for (int i = BLevel + 1; i <= height ; i++) {
                    for (TreeNode node : levelOrderMap.get(i)) {
                        if (isParentOf(node, B) && isParentOf(node, C)) {
                            return node.getVal();
                        }
                    }
                }
            }
        }
        else if (CLevel > BLevel) {
            if (isParentOf(CNode, B)) {
                return C;
            }
            else {
                //Look at levels above
                for (int i = CLevel + 1; i <= height ; i++) {
                    for (TreeNode node : levelOrderMap.get(i)) {
                        if (isParentOf(node, B) && isParentOf(node, C)) {
                            return node.getVal();
                        }
                    }
                }
            }
        }
        else {
            if (B == C) {
                return B;
            }

            for (int i = BLevel + 1; i <= height ; i++) {
                for (TreeNode node : levelOrderMap.get(i)) {
                    if (isParentOf(node, B) && isParentOf(node, C)) {
                        return node.getVal();
                    }
                }
            }
        }

        return 0;
    }

    public boolean isParentOf(TreeNode node, int A) {
        if (node == null) {
            return false;
        }
        return node.getVal() == A || this.isParentOf(node.getLeft(), A) || this.isParentOf(node.getRight(), A);
    }

    public void levelOrderTraversal(TreeNode root, int B, int C) {
        int height = height(root);
        this.visitAtDepth(root, height, B, C);
    }

    private int height(TreeNode node) {
        if (node == null) {
            return -1;
        }
        if (node.getLeft() == null && node.getRight() == null) {
            return 0;
        }
        else {
            return 1 + Math.max( height(node.getLeft()), height(node.getRight()) );
        }
    }

    private void visitAtDepth(TreeNode node, int height, int B, int C) {
        if (height < 0 || node == null) {
            return;
        }

        if (node.getVal() == B) {
            BNode = node;
        }

        if (node.getVal() == C) {
            CNode = node;
        }
        List<TreeNode> nodesAtHeight = this.levelOrderMap.getOrDefault(height, new ArrayList<>());
        nodesAtHeight.add(node);
        this.nodeHeightMap.put(node.getVal(), height);
        this.levelOrderMap.put(height, nodesAtHeight);

        this.visitAtDepth(node.getLeft(), height - 1, B, C);
        this.visitAtDepth(node.getRight(), height - 1, B, C);
    }
}
