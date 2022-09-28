package com.code.preparations.demi.algo.leetcode.tree;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.ListNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 */
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Tree)
@LeetCode(value = 19, difficulty = Difficulty.MEDIUM)
public class RemoveNthNode {

    /**
     * Remove the nth element from the end, which follows the pattern,
     * <p></p>
     * Where it removes nth element by taking two pointers, one slow and another fast, we give the fast an upstart of
     * n, so that when fast reaches end, slow will be pointing to n-1.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0);
        start.next = head;
        ListNode fast = start; ListNode slow = start;

        while(n >= 0) {
            fast = fast.next;
            n--;
        }

        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return start.next;
    }

}
