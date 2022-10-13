package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.ListNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * There is a singly-linked list head and we want to delete a node node in it.
 *<p></p>
 * You are given the node to be deleted node. You will not be given access to the first node of head.
 *<p></p>
 * All the values of the linked list are unique, and it is guaranteed that the given node node is not the last node in the linked list.
 */
@LeetCode(value = 237, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.O1, space = Complexity.O1, type = ProblemType.Tree)
public class DeleteNode {

    /**
     * Delete node, which is not the last element in the array
     */
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
