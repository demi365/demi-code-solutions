package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an array of characters chars, compress it using the following algorithm:
 *<p></p>
 * Begin with an empty string s. For each group of consecutive repeating characters in chars:
 *<p></p>
 * If the group's length is 1, append the character to s.
 * <p></p>
 * Otherwise, append the character followed by the group's length.
 */
@LeetCode(value = 443, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.DataStructure)
public class StringCompression {

    public int compress(char[] chars) {
        if(chars.length == 1)
            return 1;

        int count = 1; int index = 0;
        for(int i = 1; i<chars.length; i++) {
            if(chars[i] != chars[i-1]) {
                chars[index++] = chars[i-1];
                if(count > 1) {
                    String str = count+"";
                    for(int c = 0; c< str.length(); c++) {
                        chars[index++] = str.charAt(c);
                    }
                }
                count = 1;
            } else {
                count++;
            }
        }
        chars[index++] = chars[chars.length-1];
        if(count > 1) {
            String str = count+"";
            for(int c = 0; c< str.length(); c++) {
                chars[index++] = str.charAt(c);
            }
        }

        return index;
    }
}
