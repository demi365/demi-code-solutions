package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer n, return the decimal value of the binary string formed by concatenating the binary representations of 1 to n in order, modulo 109 + 7.
 */
@LeetCode(value = 1680, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.BitManipulation)
public class BinaryConcatenation {

    public int concatenatedBinary(int n) {

        long value = 0;
        int i = 1;
        int m = 1_000_000_007;
        while (i <= n) {
            // Find the length of this binary bit. This can also be found using how many powers of 2 can this be expressed.
            String binary = Integer.toBinaryString(i);
            // shift the values to the left using this length and append new n, using OR
            value = value << binary.length() | i;
            i++;
            // use modulus to avoid overflow at each step
            value %= m;
        }
        return (int) value;
    }

}
