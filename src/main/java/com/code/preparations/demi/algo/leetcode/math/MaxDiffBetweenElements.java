package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given a 0-indexed integer array nums of size n, find the maximum difference between nums[i] and nums[j] (i.e., nums[j] - nums[i]), such that 0 <= i < j < n and nums[i] < nums[j].
 *<p></p>
 * Return the maximum difference. If no such i and j exists, return -1.
 */
@LeetCode(value = 2016, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Math)
public class MaxDiffBetweenElements {

    public int maximumDifference(int[] nums) {
        int max = -1;
        int min = nums[0];
        for(int i=1; i< nums.length; i++) {
            min = Math.min(nums[i-1] , min          );
            max = Math.max(max       , nums[i]-min  );
        }
        return max == 0 ? -1 : max;
    }

}
