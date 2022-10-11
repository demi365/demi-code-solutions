package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 *<p></p>
 * Given an integer array nums, return the sum of Hamming distances between all the pairs of the integers in nums.
 */
@LeetCode(value = 477, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.BitManipulation)
public class TotalHammingDistance {

    /**
     * The basic idea here is that, a difference occurs between any two pairs, when one bit is 0 and other bit is 1.
     * <p>
     *     Since we know this, we can group them into groups of 1s and 0s. We can find out the number of groups with 1s
     *     and then the complement of this will be 0s. Then it's easy to find the values
     * </p>
     */
    public int totalHammingDistance(int[] nums) {
        int x = 0;
        for(int a = 0; a< 32; a++) {
            int bit = 0;
            for(int num : nums) {
                bit += (num >> a) & 1;
            }
            if(bit >0)
                x += (nums.length - bit)*bit;
        }
        return x;
    }

}
