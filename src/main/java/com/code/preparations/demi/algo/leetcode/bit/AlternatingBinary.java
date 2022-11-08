package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given a string s consisting only of the characters '0' and '1'. In one operation, you can change any '0' to '1' or vice versa.
 *<p></p>
 * The string is called alternating if no two adjacent characters are equal. For example, the string "010" is alternating, while the string "0100" is not.
 *<p></p>
 * Return the minimum number of operations needed to make s alternating.
 */
@LeetCode(value = 1758, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.StringManipulation)
public class AlternatingBinary {

    /**
     * Assume we have to form a string with zero, one, zero, one.
     * Count all replacements which are needed in this way, and then make a count of it.
     * <p></p>
     * After finding the replacements we can subtract this from the length, to get the replacements needed for one, zero.
     * <p></p>
     * Minimum of these two will be the answer
     */
    public int minOperations(String s) {
        int replacements = 0;
        int count = 0;

        while (count < s.length()) {
            char bit = s.charAt(count);
            int mod = count%2;
            if(bit == '1' && mod == 0) {
                replacements++;
            } else if (bit == '0' && mod == 1) {
                replacements++;
            }
            count++;
        }

        return Math.min(s.length() - replacements, replacements);
    }
}
