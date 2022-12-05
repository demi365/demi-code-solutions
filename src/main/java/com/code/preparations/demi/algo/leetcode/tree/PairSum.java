package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.ListNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Stack;

/**
 * In a linked list of size n, where n is even, the ith node (0-indexed) of the linked list is known as the twin of the (n-1-i)th node, if 0 <= i <= (n / 2) - 1.
 *<p></p>
 * For example, if n = 4, then node 0 is the twin of node 3, and node 1 is the twin of node 2. These are the only nodes with twins for n = 4.
 * <p></p>
 * The twin sum is defined as the sum of a node and its twin.
 *<p></p>
 * Given the head of a linked list with even length, return the maximum twin sum of the linked list.
 */
@LeetCode(value = 2130, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Tree)
public class PairSum {

    public int pairSum(ListNode head) {
        Stack<Integer> eles = new Stack<>();
        ListNode tortoise = head;
        ListNode hare = head;
        // putting elements inside a stack to make sure we are keeping them in place, until first half.
        while(hare != null && hare.next != null) {
            eles.push(tortoise.val);
            tortoise = tortoise.next;
            hare = hare.next.next;
        }
        int max = Integer.MIN_VALUE;
        // for second half, we are poping elements from stack and adding with the current element.
        while (tortoise != null) {
            max = Math.max(tortoise.val + eles.pop(), max);
            tortoise = tortoise.next;
        }
        return max;
    }

}
