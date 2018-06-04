package com.dsa.trees;

import com.dsa.trees.bst.RecoverBst;

import java.util.HashMap;
import java.util.Map;

public class Runner {

    public static void main(String[] args) {
//        Node root = new Node(44, null, null, null);
//        BST bst = new BST(root);
//        bst.add(new Node(17));
//        bst.add(new Node(88));
//        bst.add(new Node(8));
//        bst.add(new Node(5));
//        bst.add(new Node(32));
//        bst.add(new Node(28));
//        bst.add(new Node(29));
//        Node lastNode = new Node(93);
//        bst.add(lastNode);
//        bst.add(new Node(65));
//        bst.add(new Node(47));
//        bst.add(new Node(82));
//        bst.add(new Node(76));
//        bst.add(new Node(47));
//
//        lastNode.setLeft(new Node(1234));
//        lastNode.setRight(new Node(1));
//        bst.modifiedInOrder(root);
//        Traversals traversals = new Traversals(bst);
////        traversals.preOrder();
////        System.out.println();
//        traversals.levelOrder();
        Runner runner = new Runner();
        runner.morrisInOrder();
    }

    private void morrisInOrder() {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);

        root.setLeft(five);
        root.setRight(one);

        one.setRight(eight);
        eight.setLeft(seven);

        final Map<Integer, TreeNode> parentMap = new HashMap<>();
        parentMap.put(root.getVal(), null);
        parentMap.put(five.getVal(), root);
        parentMap.put(one.getVal(), root);
        parentMap.put(eight.getVal(), one);
        parentMap.put(seven.getVal(), eight);

        MorrisInOrder morrisInOrder = new MorrisInOrder(parentMap);
        morrisInOrder.inOrderRecursive(root);
        System.out.println();
        morrisInOrder.inOrder(root);

        System.out.println(morrisInOrder.isChildOf(one, eight));
        System.out.println(morrisInOrder.inOrderPredecessor(eight).getVal());
        System.out.println(morrisInOrder.inOrderPredecessor(root, eight).getVal());
    }

    private void flattenBinaryTree() {
        TreeNode root = new TreeNode(3);

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);

        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        root.setLeft(five);
        root.setRight(one);

        one.setRight(eight);

        eight.setLeft(seven);
        two.setRight(four);

        FlattenBinaryTree flattenBinaryTree = new FlattenBinaryTree();
        flattenBinaryTree.flatten(root);
        System.out.println(root.getVal());
    }

    private void constructBinaryTree() {
        ConstructBinaryTree constructBinaryTree = new ConstructBinaryTree();
        constructBinaryTree.buildTree(new int[] {10, 9, 7, 3, 2, 6, 1, 8, 5, 4}, new int[] {3, 7, 2, 9, 6, 1, 10, 5, 8, 4});
    }

    private void lowestCommonAncestor() {
        TreeNode root = new TreeNode(3);

        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);

        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);

        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        root.setLeft(five);
        root.setRight(one);

        five.setLeft(six);
        five.setRight(two);

        one.setLeft(zero);
        one.setRight(eight);

        two.setLeft(seven);
        two.setRight(four);

        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        System.out.println(lowestCommonAncestor.lca(root, 31, 89));
    }

    private void recoverCartesianTree() {
        RecoverCartesianTree recoverCartesianTree = new RecoverCartesianTree();
        recoverCartesianTree.buildTree(new int[] {3, 7, 2, 9, 1, 6, 10, 5, 8, 4}, 0, 9);
    }

    private void recoverBst(){
        RecoverBst recoverBst = new RecoverBst();
        TreeNode root = new TreeNode(600);
        TreeNode five100 = new TreeNode(500);
        TreeNode four100 = new TreeNode(400);
        TreeNode three100 = new TreeNode(300);
        TreeNode two100 = new TreeNode(200);
        TreeNode one100 = new TreeNode(100);

        TreeNode six50 = new TreeNode(650);
        TreeNode oneThousand = new TreeNode(1000);
        TreeNode seven100 = new TreeNode(700);
        TreeNode eight100 = new TreeNode(800);
        TreeNode nine100 = new TreeNode(900);
        TreeNode eleven100 = new TreeNode(1100);

        root.setLeft(six50);
        root.setRight(seven100);

        six50.setLeft(four100);
        four100.setLeft(two100);
        two100.setLeft(one100);
        two100.setRight(three100);

        seven100.setRight(oneThousand);
        oneThousand.setRight(eleven100);
        oneThousand.setLeft(eight100);
        eight100.setLeft(five100);
        eight100.setRight(nine100);

        System.out.println(recoverBst.isBst(root, -99999, 99999));
        recoverBst.getInValidNodes().forEach(treeNode -> System.out.println(treeNode.getVal()));
    }
}
