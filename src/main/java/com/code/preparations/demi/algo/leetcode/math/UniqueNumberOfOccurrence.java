package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers arr, return true if the number of occurrences of each value in the array is unique, or false otherwise.
 */
@LeetCode(value = 1207, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.Math)
public class UniqueNumberOfOccurrence {

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> vals = new HashMap<>();
        for(int ele : arr) vals.put(ele, vals.getOrDefault(ele, 0)+1);
        Set<Integer> occurrences = new HashSet<>();
        for(int occurrence : vals.values()) {
            if(!occurrences.add(occurrence))
                return false;
        }
        return true;
    }
}
