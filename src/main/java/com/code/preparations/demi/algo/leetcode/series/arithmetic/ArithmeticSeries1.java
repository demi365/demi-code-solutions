package com.code.preparations.demi.algo.leetcode.series.arithmetic;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * An integer array is called arithmetic if it consists of at least three elements and if the difference between any two consecutive elements is the same.
 *<p></p>
 * For example, [1,3,5,7,9], [7,7,7,7], and [3,-1,-5,-9] are arithmetic sequences.
 * <p></p>
 * Given an integer array nums, return the number of arithmetic subarrays of nums.
 *<p></p>
 * A subarray is a contiguous subsequence of the array.
 */
@LeetCode(value = 413, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Math)
public class ArithmeticSeries1 {

    public int numberOfArithmeticSlices(int[] nums) {
        if (nums.length < 3)
            return 0;
        int diff = nums[1]-nums[0];
        int count = 0;
        int ans = 0;
        for(int i=1; i<nums.length-1; i++) {
            if(nums[i+1]-nums[i] == diff) {
                count++;
            } else {
                if(count > 0) {
                    ans += count*(count+1)/2;
                }
                count = 0;
                diff = nums[i+1]-nums[i];
            }
        }
        if(count > 0) {
            ans += count*(count+1)/2;
        }
        return ans;
    }

}
