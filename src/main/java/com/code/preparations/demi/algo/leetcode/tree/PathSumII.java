package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree and an integer targetSum, return all root-to-leaf paths where the sum of the node values
 * in the path equals targetSum. Each path should be returned as a list of the node values, not node references.
 *<p></p>
 * A root-to-leaf path is a path starting from the root and ending at any leaf node. A leaf is a node with no children.
 */
@LeetCode(value = 113, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON2, type = ProblemType.Tree)
public class PathSumII {

    /**
     * One of the problems, I thought could be Dynamic programming, but when we thought about it after some time,
     * it just makes us realize that it's only DFS, as there is no other possible way we can do it in a better way.
     *
     * @param root root element
     * @param targetSum target sum to find
     * @return all leaf sub points where the target sum matches the sum of nodes
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        return pathSum(root, targetSum, new ArrayList<>(), 0, new ArrayList<>());
    }

    /**
     * We iteratively go through the tree and validate if there is any leaf node, where both left and right are null.
     * <p>
     *     If we can find any which is matching sum, we add it to the result list.
     * </p>
     * <p>
     *     If this is not the leaf node, pass the list to the next left and right
     * </p>
     */
    public List<List<Integer>> pathSum(TreeNode root, int targetSum, List<List<Integer>> result, int sumTillNow, List<Integer> curr) {
        if(root != null) {
            // update list and sum with curr element
            curr.add(root.val);
            sumTillNow += root.val;
            // if this is a leaf node, we see sum matches target, if so, we add it to the result
            if(root.left == null && root.right == null) {
                if(targetSum == sumTillNow) {
                    result.add(curr);
                }
            } else {
                // else we try for left or right, if any of them is null, it doesn't matter, as at least one of them
                // will be not null, and on null elements we are not really doing any modification anyway.
                pathSum(root.left, targetSum, result, sumTillNow, new ArrayList<>(curr));
                pathSum(root.right, targetSum, result, sumTillNow, new ArrayList<>(curr));
            }
        }
        return result;
    }

}
