package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.function.Predicate;

/**
 * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
 *<p></p>
 * A valid BST is defined as follows:
 *<p></p>
 * The left subtree of a node contains only nodes with keys less than the node's key.
 *<p></p>
 * The right subtree of a node contains only nodes with keys greater than the node's key.
 *<p></p>
 * Both the left and right subtrees must also be binary search trees.
 */
@LeetCode(value = 98, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
public class ValidBinarySearchTree {

    /**
     * Something got go by, where we just go with functions and lambdas for a DSA question.
     * It worked in Leetcode anyway.
     *
     * @param root root node of BST
     * @return true if valid BST else false
     */
    @CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isValidBST(root, (x) -> false);
    }

    /**
     * We loop through this root, and we apply a function to test whether our value is small or high.
     * This was simply a test to see if functions will really work in solving leetcode problems, apparently only thing that
     * goes up is runtime a bit, but still passes out.
     */
    public boolean isValidBST(TreeNode root, Predicate<Integer> function) {
        if(root.left != null) {
            if(root.left.val >= root.val
                    || function.test(root.left.val)
                    || !isValidBST(root.left, (x) -> x >= root.val || function.test(x)))
                return false;
        }
        if(root.right != null) {
            if(root.right.val <= root.val
                    || function.test(root.right.val)
                    || !isValidBST(root.right, (x) -> x <= root.val || function.test(x)))
                return false;
        }
        return true;
    }

}
