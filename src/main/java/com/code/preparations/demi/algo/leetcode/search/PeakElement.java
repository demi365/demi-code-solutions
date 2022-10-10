package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * A peak element is an element that is strictly greater than its neighbors.
 *<p></p>
 * Given a 0-indexed integer array nums, find a peak element, and return its index. If the array
 * contains multiple peaks, return the index to any of the peaks.
 *<p></p>
 * You may imagine that nums[-1] = nums[n] = -∞. In other words, an element is always considered
 * to be strictly greater than a neighbor that is outside the array.
 *<p></p>
 * You must write an algorithm that runs in O(log n) time.
 */
@LeetCode(value = 162, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.BinarySearch)
public class PeakElement {

    /**
     * One of the problems, which does not seem like anything to do with binary search at all, but has a very confusing logic.
     * This array is unsorted, but when we try to go towards the element which is maximum from both left and right, until
     * we end up where low and high meets, then this point will be peak from both left and right.
     * <p></p>
     * This is something we can think and come up with or learn and memorize.
     */
    public int findPeakElement(int[] nums) {
        if(nums.length==1)
            return 0;

        int low = 0;
        int high = nums.length-1;
        while(low != high) {
            int mid = low+(high-low)/2;
            int next = mid+1;
            if(nums[mid] < nums[next])
                low = next;
            else
                high = mid;
        }
        return low;
    }

}
