package com.code.preparations.demi.algo.leetcode.hashing;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
 *<p></p>
 * You must write an algorithm that runs in O(n) time.
 */
@LeetCode(value = 128, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.HashTable)
public class LongestConsecutiveSeq {

    /**
     * This returns the longest consecutive sequence for the number of times this element is visited
     */
    public int longestConsecutive(int[] nums) {
        Set<Integer> values = new HashSet<>();
        for(int num : nums)
            values.add(num);

        int ans = 0;

        for(int num : nums) {
            if(!values.contains(num-1)) {
                int value = num;
                int count = 0;
                while(values.contains(value)) {
                    count++;
                    value++;
                }
                ans = Math.max(count, ans);
            }
        }

        return ans;
    }
}
