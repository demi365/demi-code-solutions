package com.codeforcers.demi.algo.leetcode.twopointer;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.
 * <p></p>
 * Note that after backspacing an empty text, the text will continue empty.
 */
@LeetCode(value = 844, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ONPlusM, type = ProblemType.TwoPointer)
public class BackspaceStringCompare {

    /**
     * This takes two strings and end points are compared. We start comparison from the final element of the string, and
     * as and when we encounter a backspace '#' here, we keep adding it to skip element, if we don't see a skip element,
     * in next loop when element is not equal to backspace, we will remove the element and continue, when we
     * see that both are not equal, we will return false.
     *
     * @param s string with backspaces
     * @param t string with backspaces
     * @return true if both are same, else false.
     */
    public boolean backspaceCompare(String s, String t) {
        int i = s.length()-1;
        int j = t.length()-1;
        int iSkip = 0;
        int jSkip = 0;

        while(i>=0 || j>=0) {
            if(i>=0 && s.charAt(i) == '#') {
                iSkip++;
                i--;
            } else if(i >= 0 && iSkip > 0) {
                iSkip--;
                i--;
            } else if(j>=0 && t.charAt(j) == '#') {
                jSkip++;
                j--;
            } else if(j >= 0 && jSkip > 0) {
                jSkip--;
                j--;
            } else if(i < 0 || j < 0) {
                return false;
            } else if(s.charAt(i) != t.charAt(j)) {
                return false;
            } else {
                i--;
                j--;
            }
        }
        return true;
    }

}
