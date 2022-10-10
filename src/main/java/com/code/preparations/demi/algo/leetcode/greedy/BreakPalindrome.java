package com.code.preparations.demi.algo.leetcode.greedy;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given a palindromic string of lowercase English letters palindrome, replace exactly one character
 * with any lowercase English letter so that the resulting string is not a palindrome
 * and that it is the lexicographically smallest one possible.
 *<p></p>
 * Return the resulting string. If there is no way to replace a character to make it not a palindrome, return an empty string.
 *<p></p>
 * A string a is lexicographically smaller than a string b (of the same length) if in the first position,
 * where a and b differ, a has a character strictly smaller than the corresponding character in b.
 * For example, "abcc" is lexicographically smaller than "abcd" because the first position
 * they differ is at the fourth character, and 'c' is smaller than 'd'.
 */
@LeetCode(value = 1328, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Greedy)
public class BreakPalindrome {

    /**
     * Iterate until we find the first occurrence of the value which is not a and replace it with a.
     * If all are a return by replacing the last character by b.
     */
    public String breakPalindrome(String palindrome) {
        if(palindrome.length() <= 1)
            return "";

        char[] word = palindrome.toCharArray();

        boolean swap = true;
        // replace the first occurrence of a character which is not 'a' with 'a'.
        for(int i=0; i<word.length/2; i++) {
            if(word[i] != 'a') {
                word[i] = 'a';
                swap = false;
                break;
            }
        }

        // if all are 'a', replace last character with 'b'.
        if(swap) {
            word[word.length-1] = 'b';
        }

        return new String(word);
    }

}
