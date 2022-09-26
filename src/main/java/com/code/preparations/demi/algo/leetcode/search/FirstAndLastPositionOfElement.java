package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.
 *<p></p>
 * If target is not found in the array, return [-1, -1].
 *<p></p>
 * You must write an algorithm with O(log n) runtime complexity.
 */
@LeetCode(value = 34, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.BinarySearch)
public class FirstAndLastPositionOfElement {

    /**
     * We can iterate until we find the element which matches our target, same as in binary search, but here, we move left
     * or right after finding one occurrence, according to our criteria to make sure we are finding first and last element
     * matching our target.
     */
    public int[] searchRange(int[] nums, int target) {
        int low = -1;

        int left = 0; int right = nums.length-1;
        // find first occurrence
        while(left<=right) {
            int mid = (right+left)/2;
            if(nums[mid] == target) {
                low = mid;
                right = mid-1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }

        int high = -1;

        left =0; right = nums.length-1;
        // find last occurrence
        while(left<=right) {
            int mid = (right+left)/2;
            if(nums[mid] == target) {
                high = mid;
                left = mid+1;
            } else if (nums[mid] > target) {
                right = mid-1;
            } else if (nums[mid] < target) {
                left = mid+1;
            }
        }

        return new int[]{low, high};
    }

}
