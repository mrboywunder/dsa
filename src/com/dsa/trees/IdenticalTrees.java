package com.dsa.trees;

public class IdenticalTrees {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p == null && q == null) {
            return true;
        }

        if((p == null && q != null) || (q == null && p != null)) {
            return false;
        }


        return (p.getVal() == q.getVal())
                && isSameTree(p.getLeft(), q.getLeft()) && isSameTree(p.getRight(), q.getRight());

    }
}
