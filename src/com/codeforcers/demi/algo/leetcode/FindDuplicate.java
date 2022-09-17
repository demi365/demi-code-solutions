package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p></p>
 * There is only one repeated number in nums, return this repeated number.
 * <p></p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 */
@LeetCode(value = 287, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Special)
public class FindDuplicate {

    /**
     * This is based on certain conditions, that there is repeated elements in the array,
     * Until we find this element, we have to keep a `while` loop, which is based off of
     * whether the loop exists or not in the link. This only applies when the numbers are also representing the indices.
     * Floyd's hare and tortoise algorithm is at play here.
     *
     * @param nums number array
     * @return duplicate element in the array
     */
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)
                break;
        }

        fast = nums[0];
        while (fast != slow) {
            fast = nums[fast];
            slow = nums[slow];
        }

        return fast;
    }

}
