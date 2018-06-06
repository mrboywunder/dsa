package com.dsa.trees;

import java.util.HashMap;
import java.util.Map;

public class MorrisInOrder {

    final Map<Integer, TreeNode> parentMap;
    final Map<Integer, TreeNode> predecessorMap = new HashMap<>();

    public MorrisInOrder(final Map<Integer, TreeNode> parentMap) {
        this.parentMap = parentMap;
    }

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

    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node.getRight() != null) {
            return findMin(node.getRight());
        }
        else {
            TreeNode parent = parentMap.get(node.getVal());
            while (parent.getRight() != null && parent.getRight() == node) {
                node = parent;
                parent = parentMap.get(parent.getVal());
            }
            return parent;
        }
    }

    public TreeNode inOrderPredecessor(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.getLeft() != null) {
            return findMax(node.getLeft());
        }
        else {
            TreeNode parent = parentMap.get(node.getVal());

            while (parent != null && parent.getLeft() != null && parent.getLeft() == node) {
                node = parent;
                parent = parentMap.get(parent.getVal());
            }
            return parent;
        }
    }

    public TreeNode inOrderPredecessor(TreeNode root, TreeNode currentNode) {
        if (currentNode.getLeft() != null) {
            return findMax(currentNode.getLeft());
        }
        if (parentMap.get(currentNode.getVal()) != null && parentMap.get(currentNode.getVal()).getRight().getVal() == currentNode.getVal()) {
            return parentMap.get(currentNode.getVal());
        }
        else {
            TreeNode predecessor = root;
            while (predecessor.getRight()!= null && isChildOf(predecessor.getRight(), currentNode)) {
                predecessor = predecessor.getRight();
                if (predecessor.getRight().getLeft().getVal() == currentNode.getVal()) {
                    break;
                }
            }
            return predecessor;
        }
    }

    boolean isChildOf(TreeNode parent, TreeNode child) {
        return parent != null && (parent.getVal() == child.getVal() || isChildOf(parent.getLeft(), child)
                || isChildOf(parent.getRight(), child));
    }

    public void inOrder(TreeNode currentNode) {
        while (currentNode != null) {
            if (currentNode.getLeft() == null) {
                visit(currentNode);
                currentNode = currentNode.getRight();
            }
            else {
                TreeNode predecessor = predecessorMap.get(currentNode.getVal());
                if ( predecessor == null) {
                    predecessor = inOrderPredecessor(currentNode);
                    predecessorMap.put(currentNode.getVal(), predecessor);
                }

                if (predecessor.getRight() == null) {
                    predecessor.setRight(currentNode);
                    currentNode = currentNode.getLeft();
                }
                else {
                    visit(currentNode);
                    currentNode = currentNode.getRight();
                    predecessor.setRight(null);
                }
            }
        }
    }

    private void visit(TreeNode node) {
        System.out.print(node.getVal() + ", " );
    }

    public void inOrderRecursive(TreeNode node) {
        if (node == null) {
            return;
        }
        inOrderRecursive(node.getLeft());
        visit(node);
        inOrderRecursive(node.getRight());
    }

}
