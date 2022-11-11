package com.code.preparations.demi.algo.leetcode.twopointer;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove some duplicates in-place such that each unique element appears at most twice.
 * The relative order of the elements should be kept the same.
 *<p></p>
 * Since it is impossible to change the length of the array in some languages,
 * you must instead have the result be placed in the first part of the array nums.
 * More formally, if there are k elements after removing the duplicates,
 * then the first k elements of nums should hold the final result.
 * It does not matter what you leave beyond the first k elements.
 *<p></p>
 * Return k after placing the final result in the first k slots of nums.
 *<p></p>
 * Do not allocate extra space for another array.
 * You must do this by modifying the input array in-place with O(1) extra memory.
 */
@LeetCode(value = 80, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.TwoPointer)
public class RemoveDuplicate {

    private static final int PRESERVE = 2;

    public int removeDuplicates(int[] nums) {

        int k = 0; int count = 0; int max = 0;

        for(int index=0; index<nums.length; index++) {
            count = 1; max = 0;
            // count elements which are duplicate
            while(index<nums.length-1 && nums[index] == nums[index+1]) {
                index++;
                count++;
            }
            // while decrementing count, as well as until we
            // reach the maximum count, keep doing in
            // place replacement of the number
            while (count > 0 && max < PRESERVE) {
                nums[k++] = nums[index];
                count--;
                max++;
            }
        }

        return k;

    }

}
