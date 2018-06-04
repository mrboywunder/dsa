package com.dsa.trees.bst;

import com.dsa.trees.TreeNode;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class RecoverBst {

    List<TreeNode> inValidNodes = new ArrayList<>();

    public List<TreeNode> recover(TreeNode root) {
        List<TreeNode> retVal = new ArrayList<>();

        if (root == null) {
            throw new RuntimeException("Null Tree provided as input");
        }

        if (inValidNodes.size() == 2) {
            //replace
        }
        if (inValidNodes.size() == 1) {
            //find suitable position in the array
        }

        return retVal;
    }

    public boolean isBst(TreeNode node, int min, int max) {

        boolean retVal = true;
        boolean isLeftTreeValid = true;
        boolean isRightTreeValid = true;

        if (node == null) {
            retVal = true;
        }

        if (node.getVal() < min || node.getVal() > max) {
            inValidNodes.add(node);
            retVal = false;
        }

        if (node.getLeft() != null) {
            if (node.getVal() <= node.getLeft().getVal()) {
                isLeftTreeValid = false;
                inValidNodes.add(node.getLeft());
            }
            else {
                isLeftTreeValid = this.isBst(node.getLeft(), min, Math.min(max, node.getVal()));
            }
        }

        if (node.getRight() != null) {
            if (node.getVal() >= node.getRight().getVal()) {
                isRightTreeValid = false;
                inValidNodes.add(node.getRight());
            }
            else {
                isRightTreeValid = this.isBst(node.getRight(), Math.max(node.getVal(), min), max);
            }

        }

        return retVal && isLeftTreeValid && isRightTreeValid;
    }
}
