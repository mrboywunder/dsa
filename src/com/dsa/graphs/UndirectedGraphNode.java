package com.dsa.graphs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UndirectedGraphNode {

    private int label;

    private List<UndirectedGraphNode> neighbors = new ArrayList<>();

    public UndirectedGraphNode(int x) {
        this.label = x;
    }
}
