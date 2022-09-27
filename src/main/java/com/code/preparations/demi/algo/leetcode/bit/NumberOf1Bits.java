package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Write a function that takes an unsigned integer and returns the number of '1' bits it has (also known as the Hamming weight).
 */
@LeetCode(value = 191, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.O1, space = Complexity.O1, type = ProblemType.BitManipulation)
public class NumberOf1Bits {

    /**
     * you need to treat n as an unsigned value
     */
    public int hammingWeight(int n) {
        int count = 0;
        // just go from 0 to 31 bits and keep counting how many bits are there, for a negative number the 32bit will be 1,
        // so 31 is the limit, as we are expected to even count the sign bit. If sign bit has to be ignored, 0 to 30 is the key
        for(int i = 0; i<32; i++) {
            count += n&1;
            n = n >>1;
        }
        return count;
    }

}
