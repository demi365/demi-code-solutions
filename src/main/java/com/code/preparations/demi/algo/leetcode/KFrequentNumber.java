package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
 */
@LeetCode(value = 347, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Bucket)
public class KFrequentNumber {

    /**
     * Idea is that after finding frequencies, we can use an algorithm to sort the keys based on values using
     * a priority queue and by passing a custom comparator.
     * <p></p>
     * After this, it's simply polling until we satisfy k index values.
     *
     * @param nums number array
     * @param k k most frequency
     * @return k most frequent numbers;
     */
    @CodeFactor(time = Complexity.ONlogN, space = Complexity.ON, type = ProblemType.HashTable)
    public int[] topKFrequent(int[] nums, int k) {

        int[] result = new int[k];

        Map<Integer, Integer> hash = new HashMap<>();
        for(int i : nums) {
            hash.put(i, hash.getOrDefault(i, 0)+1);
        }

        PriorityQueue<Integer> priority = new PriorityQueue<>((num1, num2) -> hash.get(num2) - hash.get(num1));
        priority.addAll(hash.keySet());

        int index = 0;
        while(!priority.isEmpty() && index < k) {
            result[index++] = priority.poll();
        }

        return result;
    }

}
