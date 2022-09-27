package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

@LeetCode(value = 33, difficulty = Difficulty.MEDIUM)
public class SearchInRotatedSortedArray {

    /**
     * This logic is to pick the pivot, and from there, find where exactly the target lies, and then do a binary search
     * between these two points now chosen, which is the {@code {0,pivot-1} or {pivot, len}}
     */
    @CodeFactor(time = Complexity.OLogN, space = Complexity.O1, type = ProblemType.BinarySearch)
    public int search(int[] nums, int target) {

        if(nums.length == 1)
            return nums[0] == target ? 0 : -1;

        int pivot = findPivot(nums);

        int left, right;
        if(pivot == 0) {
            left = 0;
            right = nums.length-1;
        } else if(target<nums[0]) {
            left = pivot;
            right = nums.length-1;
        } else {
            left = 0;
            right = pivot-1;
        }

        // System.out.println("Pivot : " +pivot+" left : "+left+" right : "+right);

        // pure binary search
        while(left <= right) {
            int mid = (right+left)/2;
            if(nums[mid] == target)
                return mid;
            else if(nums[mid] > target)
                right = mid-1;
            else if(nums[mid] < target)
                left = mid+1;
        }

        return -1;
    }

    public int findPivot(int[] nums) {

        if(nums[0] < nums[nums.length-1]) return 0;
        if(nums[nums.length-1] < nums[nums.length-2]) return nums.length-1;

        int left = 0, right=nums.length;
        while(left <= right) {
            int mid = (left+right)/2;

            if(nums[mid] < nums[mid-1])
                return mid;
            else if(nums[mid] > nums[0])
                left = mid+1;
            else if(nums[mid] < nums[0])
                right = mid;
        }
        return -1;

    }

}
