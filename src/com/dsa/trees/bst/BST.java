package com.dsa.trees.bst;

import com.dsa.trees.Node;
import com.dsa.trees.binary.BinaryTree;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BST extends BinaryTree{

    public BST(Node root) {
        super(root);
    }

    public void add(Node node) {
        this.add(this.getRoot(), node);
    }

    private void add(Node rootNode, Node node) {

        if (rootNode.getValue() == node.getValue()) {
            return;
        }

        if (node.getValue() > rootNode.getValue()) {
            if (rootNode.getRight() == null) {
                rootNode.setRight(node);
                node.setParent(rootNode);
                return;
            }
            else {
                this.add(rootNode.getRight(), node);
            }
        }
        else {
            if (rootNode.getLeft() == null) {
                rootNode.setLeft(node);
                node.setParent(rootNode);
                return;
            }
            else {
                this.add(rootNode.getLeft(), node);
            }
        }
    }

    private static int max =-99;

    public void modifiedInOrder(Node node) {
        if (node != null) {
            this.modifiedInOrder(node.getLeft());
            System.out.println(node.getValue());
            if (node.getValue() < max) {
                System.out.println("Inversion occured");
            }
            else {
                max = node.getValue();
            }
            this.modifiedInOrder(node.getRight());
        }
    }
}
