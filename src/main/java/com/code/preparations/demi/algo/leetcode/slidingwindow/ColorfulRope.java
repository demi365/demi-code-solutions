package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
 * <p></p>
 * Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color,
 * So she asks Bob for help. Bob can remove some balloons from the rope to make it colorful.
 * You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that
 * Bob needs to remove the ith balloon from the rope.
 * <p></p>
 * Return the minimum time Bob needs to make the rope colorful.
 */
@LeetCode(value = 1578, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.SlidingWindow)
public class ColorfulRope {

    /**
     * This can be solved using sliding window approach as well.
     */
    public int minCost(String colors, int[] neededTime) {
        if(neededTime.length == 0)
            return 0;

        // the idea in short is keep track of the sum and the max found between the range.
        // Once we find a different color, add the sum to the res and subtract max, so we leave one in the group.

        int res =0, sum = neededTime[0], max = neededTime[0];
        for (int i=1; i<neededTime.length; i++) {
            if(colors.charAt(i-1) == colors.charAt(i)) {
                sum += neededTime[i];
                // keeping track of max, which we will use to not remove from the list
                max = Math.max(neededTime[i], max);
            } else {
                // For single color, the sum and max will be same, so res will be appened with zero.
                res += sum - max;
                sum = neededTime[i];
                max = neededTime[i];
            }
        }

        // Edge case when the last two colors are same, one of them needs to be removed.
        // The sum and max was not appended to the res in the loop
        if(colors.charAt(neededTime.length-1) == colors.charAt(neededTime.length-1)) {
            res += sum - max;
        }

        return res;

    }
}
