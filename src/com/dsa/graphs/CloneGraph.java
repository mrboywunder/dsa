package com.dsa.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CloneGraph {

    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        final UndirectedGraphNode clone = new UndirectedGraphNode();


        return clone;
    }

    public void bfs(UndirectedGraphNode node) {

        final Map<Integer, UndirectedGraphNode> parentMap = new HashMap<>();
        final Map<Integer, Boolean> visitedMap = new HashMap<>();

        Set<UndirectedGraphNode> frontier = new HashSet<>();
        frontier.add(node);

        visitedMap.put(node.getLabel(), true);
        parentMap.put(node.getLabel(), null);
        int level = 0;

        while (!frontier.isEmpty()) {
            level++;
            System.out.println("Level is " + level);
            final Set<UndirectedGraphNode> next = new HashSet<>();

            for (UndirectedGraphNode frontierNode : frontier) {
                frontierNode.getNeighbors()
                        .stream()
                        .filter(undirectedGraphNode -> visitedMap.get(undirectedGraphNode.getLabel()) == null)
                        .forEach(undirectedGraphNode -> {
                            System.out.println(undirectedGraphNode.getLabel());
                            visitedMap.put(undirectedGraphNode.getLabel(), true);
                            parentMap.put(undirectedGraphNode.getLabel(), frontierNode);
                            next.add(undirectedGraphNode);
                        });
            }

            frontier = next;
        }
    }
}
