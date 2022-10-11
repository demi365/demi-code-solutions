package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once.
 *<p></p>
 * Return the single element that appears only once.
 *<p></p>
 * Your solution must run in O(log n) time and O(1) space.
 */
@LeetCode(value = 540, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.BinarySearch)
public class SingleElementInSorted {

    /**
     * The core logic is based on the fact that after the single element, all the indices will vary
     */
    public int singleNonDuplicate(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        if(nums.length%2 == 0)
            return -1;
        if(nums[0] != nums[1])
            return nums[0];
        if(nums[nums.length-1] != nums[nums.length-2])
            return nums[nums.length-1];

        int low = 0; int high = nums.length;
        while (low <= high) {
            int mid = low + (high-low)/2;
            if(mid%2 == 1) {
                if(nums[mid] == nums[mid+1]) {
                    high = mid-1;
                } else if (nums[mid] == nums[mid-1]) {
                    low = mid+1;
                } else {
                    return nums[mid];
                }
            } else {
                if(nums[mid] == nums[mid+1]) {
                    low = mid+1;
                } else if (nums[mid] == nums[mid-1]) {
                    high = mid-1;
                } else {
                    return nums[mid];
                }
            }
        }
        return -1;
    }

}
