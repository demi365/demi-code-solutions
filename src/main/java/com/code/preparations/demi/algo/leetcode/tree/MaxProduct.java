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
 * Given the root of a binary tree, split the binary tree into two subtrees by removing one edge such that the product of the sums of the subtrees is maximized.
 *<p></p>
 * Return the maximum product of the sums of the two subtrees. Since the answer may be too large, return it modulo 109 + 7.
 *<p></p>
 * Note that you need to maximize the answer before taking the mod and not after taking it.
 */
@LeetCode(value = 1339, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class MaxProduct {

    private static final int MODULO = 1000_000_007;

    public int maxProduct(TreeNode root) {
        List<Long> eles = new ArrayList<>();
        long maxSum = this.prefixSum(root, eles);
        return (int) (this.findMax(eles, maxSum) % MODULO);
    }

    public long prefixSum(TreeNode root, List<Long> elements) {
        if(root == null) {
            return 0L;
        }
        long leftSum = prefixSum(root.left, elements);
        long rightSum = prefixSum(root.right, elements);
        long sum = root.val + leftSum + rightSum;
        elements.add(sum);
        return sum;
    }

    public long findMax(List<Long> eles, long maxSum) {
        long max = 0;
        for(long val : eles) {
            long counter = maxSum - val;
            long product = counter * val;
            max = Math.max(product, max);
        }
        return max;
    }

}
