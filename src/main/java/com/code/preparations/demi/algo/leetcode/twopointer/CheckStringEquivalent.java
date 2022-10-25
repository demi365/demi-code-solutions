package com.code.preparations.demi.algo.leetcode.twopointer;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.
 *<p></p>
 * A string is represented by an array if the array elements concatenated in order forms the string.
 */
@LeetCode(value = 1662, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.TwoPointer)
public class CheckStringEquivalent {

    /**
     * This is using very low space, and takes four pointers, one to word location and another to character location.
     * After final traversal, if both the pointers reach at word1 and word2 length,
     * then before them everything should have been equal
     */
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {

        int[] word1Pointer = new int[]{0,0};
        int[] word2Pointer = new int[]{0,0};

        while(word1Pointer[0] < word1.length && word2Pointer[0] < word2.length) {
            if(word1Pointer[1] < word1[word1Pointer[0]].length() && word2Pointer[1] < word2[word2Pointer[0]].length()) {
                if(word1[word1Pointer[0]].charAt(word1Pointer[1]) != word2[word2Pointer[0]].charAt(word2Pointer[1])) {
                    return false;
                }

                if(word1Pointer[1] == word1[word1Pointer[0]].length()-1) {
                    word1Pointer[0]++;
                    word1Pointer[1] = 0;
                } else {
                    word1Pointer[1]++;
                }
                if(word2Pointer[1] == word2[word2Pointer[0]].length()-1) {
                    word2Pointer[0]++;
                    word2Pointer[1] = 0;
                } else {
                    word2Pointer[1]++;
                }
            } else {
                return false;
            }
        }

        return word1Pointer[0] == word1.length
                && word2Pointer[0] == word2.length;
    }

}
