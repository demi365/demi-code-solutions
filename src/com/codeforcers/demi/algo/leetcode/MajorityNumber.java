package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Given an array nums of size n, return the majority element.
 *<p></p>
 * The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
 */
@LeetCode(value = 169, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Special)
public class MajorityNumber {

    /**
     * This algorithm is based on the Boyer-Moore Majority Vote Algorithm, by which we say that,
     * if any element is majority, it will show itself as majority at the end.
     * <p>
     *     Full explanation
     * </p>
     * <p>
     *     We start with assuming first element as majority. While iterating through the list, if count is 0, we
     *     assume this element as majority, and start by penalizing this element by -1 for every time it doesn't appear
     *     and for everytime it appears, we add one to count.
     * </p>
     * <p>
     *     The base idea is when we find the final element, if this element was the majority, it would be never penalized.
     *     Even if we start with the wrong number as majority, then before the end. Let's say, out of 5, after first four,
     *     this number should have appeared at least twice, penalizing the other element which also has less than or equal to
     *     2 elements, then on final iteration, which ever is the majority will set itself as majority and increment count by
     *     1. Which is the count by which this number becomes majority
     * </p>
     * @param nums elements in the array
     * @return majority element
     */
    public int majorityElement(int[] nums) {
        int count =0, max = 0;
        for(int num : nums) {
            if(count ==0) {
                max = num;
            }
            count += (num == max) ? 1: -1;
        }
        return max;
    }

}
