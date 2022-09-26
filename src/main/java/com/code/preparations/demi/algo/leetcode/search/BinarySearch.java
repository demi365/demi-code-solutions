package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

@LeetCode(value = 704, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.BinarySearch)
public class BinarySearch {

    public int search(int[] nums, int target) {
        if(nums.length == 1 && nums[0] == target) return 0;
        int left = 0;
        int right = nums.length-1;
        while(left < right){
            int index = left+(right-left+1)/2;
            if(nums[index] == target) {
                return index;
            } else if(nums[index] < target) {
                left = index;
            } else if(nums[index] > target) {
                right = index-1;
            }
        }
        return nums[left] == target ? left : -1;
    }

}
