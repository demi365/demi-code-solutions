package com.code.preparations.demi.algo.leetcode.series.wordpattern;

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
 * Given a pattern and a string s, find if s follows the same pattern.
 *<p></p>
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s.
 */
@LeetCode(value = 290, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.StringManipulation)
public class WordPatternI {

    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        if (pattern.length() != words.length) {
            return false;
        }
        Map<Character, String> patterns = new HashMap<>();
        Set<String> uniques = new HashSet<>();
        for (int i=0; i< pattern.length(); i++) {
            char c = pattern.charAt(i);
            String value = patterns.get(c);
            if(value == null) {
                if(!uniques.add(words[i])) {
                    return false;
                }
                patterns.put(c, words[i]);
            } else {
                if(!value.equals(words[i])) {
                    return false;
                }
            }
        }
        return true;
    }
}
