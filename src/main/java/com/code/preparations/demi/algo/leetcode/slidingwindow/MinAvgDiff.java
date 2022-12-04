package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given a 0-indexed integer array nums of length n.
 *<p></p>
 * The average difference of the index i is the absolute difference between the average of the first i + 1 elements of nums
 * and the average of the last n - i - 1 elements. Both averages should be rounded down to the nearest integer.
 *<p></p>
 * Return the index with the minimum average difference. If there are multiple such indices, return the smallest one.
 *<p></p>
 * Note:
 *<p></p>
 * The absolute difference of two numbers is the absolute value of their difference.
 * <p></p>
 * The average of n elements is the sum of the n elements divided (integer division) by n.
 * <p></p>
 * The average of 0 elements is considered to be 0.
 */
@LeetCode(value = 2256, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.SlidingWindow)
public class MinAvgDiff {

    public int minimumAverageDifference(int[] nums) {
        if (nums.length == 1)
            return 0;
        long partOne = nums[0];
        long partTwo = 0;
        for(int i =1; i<nums.length; i++) {
            partTwo += nums[i];
        }

        long avgOne = 1;
        long avgTwo = nums.length-1;

        int ans = 0;
        long min = Math.abs(partOne/avgOne - partTwo/avgTwo);

        for(int i =1; i< nums.length; i++) {
            partOne += nums[i];
            partTwo -= nums[i];
            avgOne++;
            avgTwo = Math.max(1, avgTwo-1);
            long temp = Math.abs(partOne/avgOne - partTwo/avgTwo);
            if(temp < min) {
                ans = i;
                min = temp;
            }
        }

        return ans;
    }

}
