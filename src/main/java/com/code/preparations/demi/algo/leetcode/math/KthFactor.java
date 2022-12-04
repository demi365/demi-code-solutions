package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given two positive integers n and k. A factor of an integer n is defined as an integer i where n % i == 0.
 *<p></p>
 * Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.
 */
@LeetCode(value = 1492, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Math)
public class KthFactor {

    public int kthFactor(int n, int k) {
        for(int i=1; i<=n; i++) {
            if(n%i == 0 && --k == 0) {
                return i;
            }
        }
        return -1;
    }

}
