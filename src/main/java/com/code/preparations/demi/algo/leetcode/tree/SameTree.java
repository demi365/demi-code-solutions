package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 *<p></p>
 * Two binary trees are considered the same if they are structurally identical, and the nodes have the same value.
 */
@LeetCode(value = 100, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class SameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p ==null || q ==null)
            return p == q;
        if(p.val != q.val)
            return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
