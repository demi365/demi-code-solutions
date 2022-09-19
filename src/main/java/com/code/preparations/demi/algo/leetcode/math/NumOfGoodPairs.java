package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an array of integers nums, return the number of good pairs.
 *<p></p>
 * A pair (i, j) is called good if nums[i] == nums[j] and i < j.
 */
@LeetCode(value = 1512, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Math)
public class NumOfGoodPairs {

    public int numIdenticalPairs(int[] nums) {
        int[] freq = new int[101];

        for(int num : nums) freq[num]++;

        int sum = 0;
        for(int fre : freq) {
            if(fre > 1) {
                sum += (fre*(fre-1))/2;
            }
        }
        return sum;
    }

}
