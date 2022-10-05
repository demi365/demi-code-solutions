package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the root of a binary tree and two integers val and depth, add a row of nodes with value val at the given depth depth.
 *<p></p>
 * Note that the root node is at depth 1.
 *<p></p>
 * The adding rule is:
 *<p></p>
 * Given the integer depth, for each not null tree node cur at the depth depth - 1, create two tree nodes with value val as
 * cur's left subtree root and right subtree root.
 * <p></p>
 * cur's original left subtree should be the left subtree of the new left subtree root.
 * <p></p>
 * cur's original right subtree should be the right subtree of the new right subtree root.
 * <p></p>
 * If depth == 1 that means there is no depth, depth - 1 at all, then create a tree node with value val as the new root of the whole original tree,
 * and the original tree is the new root's left subtree.
 */
@LeetCode(value = 623, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
public class AddOneLevelToTree {

    /**
     * Depth equals to 1 is a special case,
     * Rest can be added on the level before it, by just changing the left and right values.
     * This triggers a level order search
     */
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth == 1) {
            return new TreeNode(val, root, null);
        }
        this.addOneRow(root, val, depth-1, 1);
        return root;
    }

    public void addOneRow(TreeNode root, int val, int depth, int cur) {
        if (root == null) {
            return;
        }
        if(depth == cur) {
            TreeNode leftNode = root.left;
            root.left = new TreeNode(val, leftNode, null);
            TreeNode rightNode = root.right;
            root.right = new TreeNode(val, null, rightNode);
            return;
        }
        this.addOneRow(root.left, val, depth, cur+1);
        this.addOneRow(root.right, val, depth, cur+1);

    }

}
