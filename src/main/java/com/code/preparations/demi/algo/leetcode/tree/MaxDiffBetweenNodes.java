package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the root of a binary tree, find the maximum value v for which there exist different nodes 'a' and 'b' where
 * {@code v = |a.val - b.val|} and 'a' is an ancestor of 'b'.
 *<p></p>
 * A node 'a' is an ancestor of b if either: any child of 'a' is equal to 'b' or any child of 'a' is an ancestor of 'b'.
 */
@LeetCode(value = 1026, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
public class MaxDiffBetweenNodes {

    public int maxAncestorDiff(TreeNode root) {
        if(root == null)
            return 0;
        return maxAncestorDiff(root, root.val, root.val);
    }

    public int maxAncestorDiff(TreeNode root, int max, int min) {
        if(root.left == null && root.right == null) {
            // System.out.println("Diff between max "+max+" and min "+min);
            return max-min;
        }

        int diff1 = 0; int diff2 = 0;
        if(root.left != null) {
            diff1 = maxAncestorDiff(root.left, Math.max(max, root.left.val), Math.min(min, root.left.val));
        }
        if(root.right != null) {
            diff2 = maxAncestorDiff(root.right, Math.max(max, root.right.val), Math.min(min, root.right.val));
        }

        return Math.max(diff1, diff2);
    }

}
