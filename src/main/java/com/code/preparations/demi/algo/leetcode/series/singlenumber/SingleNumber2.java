package com.code.preparations.demi.algo.leetcode.series.singlenumber;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer array nums where every element appears three times except for one,
 * which appears exactly once. Find the single element and return it.
 *<p></p>
 * You must implement a solution with a linear runtime complexity and use only constant extra space.
 */
@LeetCode(value = 137, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.BitManipulation)
public class SingleNumber2 {

    public int singleNumber(int[] nums) {
        int val = 0;

        int pow = 1;
        for(int a=0; a<32; a++) {
            int bit = 0;
            for (int num : nums) {
                bit += num >> a & 1;
            }
            val += pow*(bit%3);
            pow *= 2;
        }

        return val;
    }

}
