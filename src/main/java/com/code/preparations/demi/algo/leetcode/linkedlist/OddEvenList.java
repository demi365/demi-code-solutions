package com.code.preparations.demi.algo.leetcode.linkedlist;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.data.ListNode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.
 *<p></p>
 * The first node is considered odd, and the second node is even, and so on.
 *<p></p>
 * Note that the relative order inside both the even and odd groups should remain as it was in the input.
 *<p></p>
 * You must solve the problem in O(1) extra space complexity and O(n) time complexity.
 */
@LeetCode(value = 328, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.SlidingWindow)
public class OddEvenList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next ==null || head.next.next == null)
            return head;

        ListNode point = head;
        ListNode prev = head.next;
        ListNode hare = head.next.next;
        ListNode second = head.next;

        while (hare != null) {
            // System.out.println("Hare and point is "+hare.val+" "+point.val);
            prev.next = hare.next;
            point.next = hare;
            hare.next = second;
            // System.out.println("Prev is "+prev.val+" hare is "+hare.val+" point is "+point.val);
            if (prev.next != null) {
                point = point.next;
                prev = prev.next;
                hare = prev.next;
            } else {
                hare = null;
            }
        }

        return head;
    }


}
