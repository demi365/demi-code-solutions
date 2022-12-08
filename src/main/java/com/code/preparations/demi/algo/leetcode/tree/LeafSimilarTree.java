package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.TreeNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves form a leaf value sequence.
 *<p></p>
 * For example, in the given tree above, the leaf value sequence is (6, 7, 4, 9, 8).
 *<p></p>
 * Two binary trees are considered leaf-similar if their leaf value sequence is the same.
 *<p></p>
 * Return true if and only if the two given trees with head nodes root1 and root2 are leaf-similar.
 */
@LeetCode(value = 872, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.Tree)
public class LeafSimilarTree {

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafSimilar1 = leafSimilar(root1, new ArrayList<>());
        List<Integer> leafSimilar2 = leafSimilar(root2, new ArrayList<>());

        if(leafSimilar1.size() != leafSimilar2.size()) {
            return false;
        }

        for(int i=0; i<leafSimilar1.size() ; i++) {
            if(!Objects.equals(leafSimilar1.get(i), leafSimilar2.get(i))) {
                return false;
            }
        }

        return true;
    }

    public List<Integer> leafSimilar(TreeNode root, List<Integer> leaves) {
        if(root == null) {
            return leaves;
        }
        if(root.left == null && root.right == null) {
            leaves.add(root.val);
            return leaves;
        }
        if(root.left != null) {
            leafSimilar(root.left , leaves);
        }
        if(root.right != null) {
            leafSimilar(root.right, leaves);
        }
        return leaves;
    }
}
