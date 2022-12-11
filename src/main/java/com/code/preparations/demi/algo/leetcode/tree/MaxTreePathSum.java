package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * <p></p>
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 *<p></p>
 * The path sum of a path is the sum of the node's values in the path.
 *<p></p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 *
 */
@LeetCode(value = 124, difficulty = Difficulty.HARD)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class MaxTreePathSum {

    private int sum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPath(root);
        return sum;
    }

    public int maxPath(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int sumLeft = maxPath(root.left);
        int sumRight = maxPath(root.right);

        int max = Math.max(root.val,
                Math.max(
                        root.val+sumLeft+sumRight,
                        Math.max(root.val+sumLeft, root.val+sumRight)
                )
        );

        sum = Math.max(sum, max);

        return Math.max(
                Math.max(
                        root.val+sumLeft, root.val+sumRight
                ),
                root.val
        );
    }
}
