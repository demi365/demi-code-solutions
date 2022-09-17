package com.codeforcers.demi.algo.dev;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.data.ListNode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Finding the middle of a linked list is an absolutely good idea.
 */
@LeetCode(value = 876, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Special)
public class MiddleOfLinkedList {

    /**
     * This takes based on Floyd's hare and tortoise algorithm.
     * This is mainly based on how hare will travel at twice the speed of tortoise, and when hare reaches the end,
     * the tortoise will be pointing to the middle of the element.
     *
     * @param head start of linked list
     * @return middle point
     */
    public ListNode middleNode(ListNode head) {
        ListNode hare = head;
        ListNode tortoise = head;
        while(hare != null && hare.next != null) {
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return tortoise;
    }

}
