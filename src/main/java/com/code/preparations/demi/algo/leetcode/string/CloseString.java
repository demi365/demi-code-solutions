package com.code.preparations.demi.algo.leetcode.string;

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
 * Two strings are considered close if you can attain one from the other using the following operations:
 *<p></p>
 * Operation 1: Swap any two existing characters.<p></p>
 * For example, abcde -> aecdb<p></p>
 * Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.<p></p>
 * For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)<p></p>
 * You can use the operations on either string as many times as necessary.
 *<p></p>
 * Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.
 *
 */
@LeetCode(value = 1657, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.StringManipulation)
public class CloseString {

    public boolean closeStrings(String word1, String word2) {
        if(word1.length() != word2.length())
            return false;
        int[] frequency1 = new int[26];
        int[] frequency2 = new int[26];
        for(int i =0; i<word1.length(); i++) {
            frequency1[word1.charAt(i) - 'a']++;
            frequency2[word2.charAt(i) - 'a']++;
        }
        for(int i =0; i<26; i++) {
            if((frequency1[i] ==0 && frequency2[i] != 0)
                    ||(frequency1[i] !=0 && frequency2[i] == 0)) {
                return false;
            }
        }

        Map<Integer, Integer> counter = new HashMap<>();
        for(int i = 0; i< 26; i++) {
            counter.merge(frequency1[i], 1, Integer::sum);
            counter.merge(frequency2[i], -1, Integer::sum);
        }
        Set<Integer> finalVal = new HashSet<>(counter.values());

        return finalVal.size() == 1 && finalVal.contains(0);
    }
}
