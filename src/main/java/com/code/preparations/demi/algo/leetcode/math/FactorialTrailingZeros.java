package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 *<p></p>
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1
 */
@LeetCode(value = 172, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.Math)
public class FactorialTrailingZeros {

    /**
     * Basically a 0 is formed, whenever we encounter a 5 or multiple of 5.
     * We can assume we will have ample amount of 2's as 2 is generated every two numbers. The maximum zeros is limited by
     * number of 5s. Number of 5s will be 5,10,15, etc. One more thing to note is 25 is 2 5s, so we have to consider
     * multiples of 25 as another counter.
     */
    public int trailingZeroes(int n) {
        int i = 5;
        int ans = 0;
        while (n/i>=1) {
            ans += n/i;
            i *= 5;
        }
        return ans;
    }

}
