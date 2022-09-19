package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer array nums, return the greatest common divisor of the smallest number and largest number in nums.
 *<p></p>
 * The greatest common divisor of two numbers is the largest positive integer that evenly divides both numbers.
 */
@LeetCode(value = 1979, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Math)
public class GCD {

    /**
     * Finding GCD is simply the most mathematical problem we can find.
     * @param nums nums array
     * @return GCD between the largest number and the smallest number.
     */
    public int findGCD(int[] nums) {
        if(nums == null || nums.length ==0)
            return 1;

        int smallest = nums[0]; int largest = nums[0];
        for(int i = 1; i<nums.length; i++) {
            smallest = Math.min(nums[i], smallest);
            largest = Math.max(nums[i], largest);
        }
        if(smallest == largest || largest%smallest == 0) {
            return smallest;
        }

        return findGCD(smallest, largest);
    }

    /**
     * This is the logic to find the GCD between two numbers
     * @param smallest smallest number of the two
     * @param largest largest number of the two
     * @return GCD between them
     */
    private static int findGCD(int smallest, int largest) {
        int num = largest;
        int div = smallest;

        while (div != 0) {
            int temp = div;
            div = num%div;
            num = temp;
        }
        return num;
    }

}
