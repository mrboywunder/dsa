package com.dsa.trees;

import com.dsa.trees.binary.BinaryTree;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Traversals {

    private BinaryTree binaryTree;

    private void visit(Node node) {
        System.out.print(node.getValue() + " ");
    }

    public void preOrder() {
        this.preOrder(this.getBinaryTree().getRoot());
    }

    public void levelOrder() {
        this.levelOrder(this.getBinaryTree().getRoot());
    }


    private void preOrder(Node node) {
        if (node != null) {
            this.visit(node);
            this.preOrder(node.getLeft());
            this.preOrder(node.getRight());
        }

    }

    private void postOrder(Node node) {
        if (node != null) {
            this.postOrder(node.getLeft());
            this.postOrder(node.getRight());
            this.visit(node);
        }
    }

    private void inOrder(Node node) {
        if (node != null) {
            this.inOrder(node.getLeft());
            this.visit(node);
            this.inOrder(node.getRight());
        }
    }

    public int getHeight(Node node) {
        if (node == null) {
            return -1;
        }
        if (node.isLeaf()) {
            return 0;
        }
        else {
            return 1 + Math.max(this.getHeight(node.getLeft()), this.getHeight(node.getRight()));
        }
    }

    private void levelOrder(Node node) {
        int height = this.getHeight(node);
        for (int i = 0; i <= height; i++) {
            System.out.println("----------------- Level " + i + " -------------------");
            this.printLeaves(node, i);
            System.out.println();
        }
    }

    private void printLeaves(Node node, int height) {
        if (node == null) {
            return;
        }
        if (height == 0) {
            this.visit(node);
            return;
        }
        else {
            this.printLeaves(node.getRight(), height-1);
            this.printLeaves(node.getLeft(), height-1);
        }
    }

}
