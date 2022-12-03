package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Given a string s, sort it in decreasing order based on the frequency of the characters.
 * <p></p>
 * The frequency of a character is the number of times it appears in the string.
 * <p></p>
 * Return the sorted string. If there are multiple answers, return any of them.
 */
@LeetCode(value = 451, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ONlogN, type = ProblemType.StringManipulation)
public class SortStringAsPerFrequency {

    public String frequencySort(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for(char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0)+1);
        }

        PriorityQueue<Character> priority = new PriorityQueue<>((p1, p2) -> hash.get(p2)-hash.get(p1));
        priority.addAll(hash.keySet());

        StringBuilder sb = new StringBuilder();

        while(!priority.isEmpty()) {
            char c = priority.poll();
            int repeats = hash.get(c);
            while(repeats>0) {
                sb.append(c);
                repeats--;
            }
        }

        return sb.toString();
    }

}
