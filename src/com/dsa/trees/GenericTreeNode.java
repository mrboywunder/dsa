package com.dsa.trees;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class GenericTreeNode {

    private int value;
    private Set<GenericTreeNode> incomingNodes = new HashSet<>();
    private HashMap<GenericTreeNode, Integer> weightMap = new HashMap<>();

    public GenericTreeNode(int value) {
        this.value = value;
    }

    public void addIncomingNodes(GenericTreeNode node, Integer weight) {
        this.incomingNodes.add(node);
        weightMap.put(node, weight);
    }

    public Integer getWeight(GenericTreeNode node) {
        return this.weightMap.get(node);
    }
}
