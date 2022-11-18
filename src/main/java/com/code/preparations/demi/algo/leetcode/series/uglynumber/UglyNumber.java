package com.code.preparations.demi.algo.leetcode.series.uglynumber;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * An ugly number is a positive integer whose prime factors are limited to 2, 3, and 5.
 *<p></p>
 * Given an integer n, return true if n is an ugly number.
 */
@LeetCode(value = 263, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.Math)
public class UglyNumber {

    public boolean isUgly(int n) {
        if(n<=0)
            return false;
        while (n%2==0) n=n/2;
        while (n%3==0) n=n/3;
        while (n%5==0) n=n/5;
        return n == 1;
    }

}
