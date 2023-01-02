package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p></p>
 * All letters in this word are capitals, like "USA".
 * <p></p>
 * All letters in this word are not capitals, like "leetcode".
 * <p></p>
 * Only the first letter in this word is capital, like "Google".
 * <p></p>
 * Given a string word, return true if the usage of capitals in it is right.
 */
@LeetCode(value = 520, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.StringManipulation)
public class DetectCapital {

    public boolean detectCapitalUse(String word) {
        boolean allCaps = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
        boolean allSmall = word.charAt(0) >= 'a' && word.charAt(0) <= 'z';
        boolean oneCaps = allCaps;
        for(int i = 1; i<word.length(); i++) {
            char c = word.charAt(i);
            if(c >= 'A' && c<= 'Z') {
                oneCaps = false;
                allSmall = false;
            }
            if(c >= 'a' && c<= 'z') {
                allCaps = false;
            }
        }
        return allCaps || allSmall || oneCaps;
    }

}
