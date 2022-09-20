package com.code.preparations.demi.algo.leetcode.matrix;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;

@LeetCode(value = 718, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONM, space = Complexity.ONM, type = ProblemType.DynamicProgramming)
public class MaxLengthOfRepeatedNumbers {

    private int ans = 0;

    /**
     * Given two integer arrays nums1 and nums2, return the maximum length of a subarray that appears in both arrays.
     */
    public int findLength(int[] nums1, int[] nums2) {
        int[][] dp =  new int[nums1.length][nums2.length];
        for(int[] arr : dp )
            Arrays.fill(arr, -1);

        findLength(nums1, nums2, 0, 0, dp);

        return ans;
    }

    /**
     * Find until we have the count of all elements from the list based on iterating over and over again.
     * When we land on this n and m, if we have found a match, add 1 and continue the trial, else
     * continue trail skipping either i or j, and starting from zero.
     */
    private int findLength(int[] nums1, int[] nums2, int i, int j, int[][] dp) {
        if(i == nums1.length || j == nums2.length) {
            return 0;
        }

        if(dp[i][j] != -1) {
            return dp[i][j];
        }

        if(nums1[i] == nums2[j]) {
            dp[i][j] = 1 + findLength(nums1, nums2, i+1, j+1, dp);
        } else {
            dp[i][j] = 0;
        }

        findLength(nums1, nums2, i+1, j  , dp);
        findLength(nums1, nums2, i  , j+1, dp);

        ans = Math.max(ans, dp[i][j]);

        return dp[i][j];

    }
}
