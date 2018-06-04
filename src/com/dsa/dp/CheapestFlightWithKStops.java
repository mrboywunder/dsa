package src.dsa.dp;

import src.dsa.trees.GenericTreeNode;

import java.util.HashMap;
import java.util.Map;

public class CheapestFlightWithKStops {

    public void init() {
    }

    public CheapestFlightWithKStops() {
        this.init();
    }

    public int getCost(GenericTreeNode source, GenericTreeNode destination, int kStops) {
        final Map<Integer, Integer> nodeCostMap = new HashMap<>();

        if (kStops == 0 && source.getValue() != destination.getValue()) {
            return 99999999;
        }

        for (GenericTreeNode node : destination.getIncomingNodes()) {
            nodeCostMap.put(node.getValue(), getCost(source, node, kStops - 1) + destination.getWeight(node));
        }

        Integer minCost = 0;
        for ( Integer cost: nodeCostMap.values()) {
            if (minCost == 0) {
                minCost = cost;
            }
            else {
                if (minCost > cost) {
                    minCost = cost;
                }
            }
        }

        return minCost;
    }
}
