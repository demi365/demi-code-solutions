package com.code.preparations.demi.algo.leetcode.dp;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer n, return the least number of perfect square numbers that sum to n.
 *<p></p>
 * A perfect square is an integer that is the square of an integer; in other words,
 * it is the product of some integer with itself.
 * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
 */
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.DynamicProgramming)
@LeetCode(value = 279, difficulty = Difficulty.MEDIUM)
public class PerfectSquares {

    /**
     * The least number of square numbers which add up to the given number has to be identified for each type of square.
     * @param n input number
     * @return least number of square numbers which add up to n
     */
    public int numSquares(int n) {
        return this.numSquares(
                n,
                new int[n+1]
        );
    }

    public int numSquares(int n, int[] dp) {

        if(n==0) return 0;
        if(dp[n] != 0) return dp[n];

        int min = n;
        for (int i = 1; i*i <= n; i++) {
            int count = 1 + numSquares(n-i*i, dp);
            min = Math.min(min, count);
        }
        dp[n] = min;
        return dp[n];
    }

}
