package com.dsa.trees;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Node {

    private Integer value;
    private Node left;
    private Node right;
    private Node parent;

    public Node(Integer value) {
        this.value = value;
    }

    public Boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }
}
