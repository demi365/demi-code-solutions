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
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */
@LeetCode(value = 144, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class PreOrder {

    public List<Integer> preorderTraversal(TreeNode root) {
        return preOrder(root, new ArrayList<>());
    }

    public List<Integer> preOrder(TreeNode node, List<Integer> items) {
        if (node != null) {
            items.add(node.val);
            preOrder(node.left,  items);
            preOrder(node.right, items);
        }
        return items;
    }
}
