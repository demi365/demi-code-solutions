package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer array nums, return true if there exists a triple of indices (i, j, k)
 * such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.
 */
@LeetCode(value = 334, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.BinarySearch)
public class IncreasingTriplet {

    /**
     * A special case of {@link LongestIncreasingSeq} where only three elements needs to be found.
     * @param nums
     * @return
     */
    public boolean increasingTriplet(int[] nums) {
        int first = Integer.MAX_VALUE; int second = Integer.MAX_VALUE;

        for(int val : nums) {
            if (val <= first) {
                first = val;
            } else if (val <= second) {
                second = val;
            } else {
                return true;
            }
        }

        return false;
    }

}
