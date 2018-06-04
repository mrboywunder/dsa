package com.dsa.dp;

import com.dsa.trees.GenericTreeNode;

import java.util.HashSet;
import java.util.Set;

public class DPRunner {

    public static void main(String[] args) {
//        LongestValidParantheses l = new LongestValidParantheses();
//        System.out.println(l.isValid("(((())))"));
//        GenericTreeNode source = new GenericTreeNode(-99);
//        GenericTreeNode A = new GenericTreeNode(1);
//        GenericTreeNode B = new GenericTreeNode(2);
//        GenericTreeNode C = new GenericTreeNode(3);
//        GenericTreeNode D = new GenericTreeNode(4);
//        GenericTreeNode destination = new GenericTreeNode(99);
//
//        A.addIncomingNodes(source, 1);
//
//        B.addIncomingNodes(A, 1);
//        B.addIncomingNodes(source, 1);
//
//        C.addIncomingNodes(D, 1);
//        C.addIncomingNodes(B, 1);
//
//        D.addIncomingNodes(A, 1);
//        D.addIncomingNodes(B, 1);
//        D.addIncomingNodes(source, 100);
//
//        destination.addIncomingNodes(D, 1);
//        destination.addIncomingNodes(C, 1);
//
//        CheapestFlightWithKStops cheapestFlightWithKStops = new CheapestFlightWithKStops();
//        System.out.println(cheapestFlightWithKStops.getCost(source, destination, 3));
//        Set<Integer> input = new HashSet<>();
//        input.add(1);
//        input.add(2);
//        input.add(3);
////        input.add(4);
//        AllSubsets allSubsets = new AllSubsets();
//        allSubsets.findAll(input)
//                .stream()
//                .forEach(integers -> {
//                    integers.stream()
//                            .forEach(integer -> {
//                                System.out.print(integer + ", ");
//                            });
//                    System.out.println();
//                });
//    }
        FindUniquePaths findUniquePaths = new FindUniquePaths();
        findUniquePaths.findPaths();
    }
}
