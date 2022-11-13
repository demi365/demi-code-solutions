package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an input string s, reverse the order of the words.
 *<p></p>
 * A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
 *<p></p>
 * Return a string of the words in reverse order concatenated by a single space.
 *<p></p>
 * Note that s may contain leading or trailing spaces or multiple spaces between two words.
 * The returned string should only have a single space separating the words. Do not include any extra spaces.
 *
 */
@LeetCode(value = 151, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.StringManipulation)
public class ReverseWord {

    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] words = s.split(" ");

        sb.append(words[words.length-1]);

        for(int index = words.length-2; index >= 0; index--) {
            if(!words[index].trim().equals("")) {
                sb.append(" ");
                sb.append(words[index]);
            }
        }
        return sb.toString();
    }

}
