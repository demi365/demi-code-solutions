package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;

/**
 * Given an integer array nums, return the largest perimeter of a triangle with a non-zero area,
 * formed from three of these lengths. If it is impossible to form any triangle of a non-zero area, return 0.
 */
@LeetCode(value = 976, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ONlogN, space = Complexity.O1, type = ProblemType.Math)
public class LargestPerimeterTriangle {

    /**
     * Finding the largest perimeter is as simple as checking if the sum of the two smallest
     * elements is less than the third size. If this satisfies, then we have our triangle.
     */
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        for(int i = nums.length-1; i>= 2; i--) {
            if(nums[i] < nums[i-1]+nums[i-2]) {
                return nums[i]+nums[i-1]+nums[i-2];
            }
        }
        return 0;
    }

}
