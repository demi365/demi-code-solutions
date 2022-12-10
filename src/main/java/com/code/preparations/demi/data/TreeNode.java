package com.code.preparations.demi.data;

import java.util.List;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {}
    public TreeNode(int val) { this.val = val; }
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public static List<Integer> traverse(TreeNode root, List<Integer> fullList) {
        if(root == null) {
            return fullList;
        }
        fullList.add(root.val);
        traverse(root.left, fullList);
        traverse(root.right, fullList);
        return fullList;
    }

}