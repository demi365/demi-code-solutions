package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the root node of a binary search tree and two integers low and high.
 * <p></p>
 * Return the sum of values of all nodes with a value in the inclusive range [low, high].
 */
@LeetCode(value = 938, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
public class RangeSumBST {

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null)
            return 0;
        int range = 0;
        if(root.val >= low && root.val <= high) {
            range += root.val;
        }

        if(root.val > low)
            range += rangeSumBST(root.left, low, high);
        if(root.val < high)
            range += rangeSumBST(root.right, low, high);

        return range;
    }
}
