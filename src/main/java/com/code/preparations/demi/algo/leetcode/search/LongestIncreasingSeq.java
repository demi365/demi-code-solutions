package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 *<p></p>
 * A subsequence is a sequence that can be derived from an array by deleting some or no elements without changing
 * the order of the remaining elements. For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
@LeetCode(value = 300, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONlogN, space = Complexity.ON, type = ProblemType.BinarySearch)
public class LongestIncreasingSeq {

    /**
     * This is a complex logic, but the basic idea behind this is that, whenever we see a number smaller than maximum,
     * we insert into it's rightful place, so that the next sequence can be found
     */
    public int lengthOfLIS(int[] nums) {
        int[] leftMax = new int[nums.length];
        leftMax[0] = nums[0];

        int max = 0;

        for(int val : nums) {
            if(leftMax[max] < val) {
                leftMax[++max] = val;
            } else {
                int left = 0; int right = max;
                while (left < right) {
                    int mid = left+(right-left)/2;
                    if(leftMax[mid] == val) {
                        left = mid;
                        break;
                    } else if (leftMax[mid] < val) {
                        left = mid+1;
                    } else {
                        right = mid;
                    }
                }
                leftMax[left] = val;
            }
        }

        return max+1;
    }
}
