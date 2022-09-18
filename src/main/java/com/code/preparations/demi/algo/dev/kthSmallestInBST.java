package com.code.preparations.demi.algo.dev;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;
import com.code.preparations.demi.data.TreeNode;

/**
 * Given the root of a binary search tree, and an integer k, return the kth smallest value
 * (1-indexed) of all the values of the nodes in the tree.
 */
@LeetCode(value = 230, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.BST)
public class kthSmallestInBST {

    /**
     * This logic does not use a dp or an array to use.
     * @param root root
     * @param k kth smallest element
     * @return kth smallest element
     */
    public int kthSmallest(TreeNode root, int k) {
        return kthPosition(root, k)[1];
    }

    /**
     * This returns null if we have reached the end.
     * We are using a length 2 array to send a tuple of values.
     * <p>
     *     1. If {@code leftNode} index is 0, we have reached the element we want to find, we return.
     *     Same should be done for other {@code rightNode} as well as {@code currNode}.
     * </p>
     * <p>
     *     If the node we expect is not yet found, we decrement k, after we have reached all the left nodes.
     * </p>
     * @param root parent root element
     * @param k k value which is updated after all left elements are exhausted.
     * @return final element which is present at the Kth smallest index, along with 0.
     */
    public int[] kthPosition(TreeNode root, int k) {
        if(root == null)
            return new int[]{k, 0};
        int[] leftNode = kthPosition(root.left, k);
        if(leftNode[0] == 0) return leftNode;
        int[] currNode = new int[]{leftNode[0]-1, root.val};
        if(currNode[0] == 0) return currNode;
        return kthPosition(root.right, leftNode[0]-1);
    }

}
