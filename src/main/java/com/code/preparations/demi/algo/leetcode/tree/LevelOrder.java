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
 * Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
 */
@LeetCode(value = 102, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        return levelOrder(root, new ArrayList<>(), 1);
    }

    /**
     * We just traverse passing a list of list to the levelOrder, which also
     * contains the current level of the order.
     * If we don't find this order in the levels list, we create a new array list, until we reach this new level
     * [Mostly this should be only once],
     * Then we pass with level+1 to left, and level+1 to right.
     * Which keeps adding the values in order to their levels.
     */
    public List<List<Integer>> levelOrder(TreeNode root, List<List<Integer>> levels, int currLevel) {
        if(root == null)
            return levels;
        while(levels.size() < currLevel) {
            levels.add(new ArrayList<>());
        }
        // the place we add to the list, by getting the current level and just adding the value.
        levels.get(currLevel-1).add(root.val);

        // add left
        levelOrder(root.left, levels, currLevel+1);
        // add right
        levelOrder(root.right, levels, currLevel+1);
        return levels;
    }

}
