package com.code.preparations.demi.algo.leetcode.dp;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;

/**
 * You are a professional robber planning to rob houses along a street.
 * <p></p>
 * Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is
 * that adjacent houses have security systems connected,
 * and it will automatically contact the police if two adjacent houses were broken into on the same night.
 *<p></p>
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the police.
 */
@LeetCode(value = 198, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.DynamicProgramming)
public class HouseRobber {

    public int rob(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return Math.max(
                max(nums, 0, dp),
                max(nums, 1, dp)
        );
    }

    public int max(int[] nums, int index, int[] dp) {

        if(index >= nums.length) {
            return 0;
        }
        if(dp[index] != -1) {
            return dp[index];
        }

        int ans = nums[index];
        for(int next = index+2; next<nums.length; next++) {
            int x = max(nums, next, dp);
            ans = Math.max(ans, x+nums[index]);
        }
        dp[index] = ans;
        return ans;
    }

}
