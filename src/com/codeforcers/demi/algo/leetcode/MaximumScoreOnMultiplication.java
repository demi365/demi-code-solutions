package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.enums.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * You are given two integer arrays nums and multipliers of size n and m respectively, where n >= m. The arrays are 1-indexed.
 *<p></p>
 * You begin with a score of 0. You want to perform exactly m operations. On the ith operation (1-indexed), you will:
 *<p></p>
 * Choose one integer x from either the start or the end of the array nums.
 * Add multipliers[i] * x to your score.
 * Remove x from the array nums.
 * Return the maximum score after performing m operations.
 */
@LeetCode(value = 1770, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON2, time = Complexity.ON2, type = ProblemType.DynamicProgramming)
public class MaximumScoreOnMultiplication {

    /**
     * There is no other possibility than computing each and every case, and in this scenario, the only possibility is
     * to look at each combination and try what can be the maximum solution.
     *
     * @param nums input array
     * @param multipliers multipler array
     * @return maximum score
     */
    public int maximumScore(int[] nums, int[] multipliers) {
        return maximumScore(nums, multipliers, 0, 0, new int[1001][1001]);
    }

    /**
     * The already visited nodes can be set in a array of size 1000.
     * As the input was restricted to 1<=1000 indices for the size of m.
     * This is possible for the values are set this way.
     *
     * @param nums Number array
     * @param multipliers multiplier array
     * @param m length of m
     * @param s start index
     * @param memArray mem array, which stores the visited values, for dynamic programming
     * @return maximum score corresponding to the values for constraints m and s.
     */
    public int maximumScore(int[] nums, int[] multipliers, int m, int s, int[][] memArray) {
        if(m == multipliers.length) return 0;

        if(memArray[m][s] != 0) return memArray[m][s];

        int e = (nums.length - 1) - (m-s);
        int p1 = nums[s]*multipliers[m] + maximumScore(nums, multipliers, m+1, s+1, memArray);
        int p2 = nums[e]*multipliers[m] + maximumScore(nums, multipliers, m+1, s, memArray);

        memArray[m][s] = Math.max(p1, p2);

        return memArray[m][s];
    }
}
