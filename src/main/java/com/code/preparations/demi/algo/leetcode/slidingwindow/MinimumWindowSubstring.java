package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given two strings s and t of lengths m and n respectively, return the minimum window substring of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".
 *<p></p>
 * The testcases will be generated such that the answer is unique.
 *<p></p>
 * A substring is a contiguous sequence of characters within the string.
 */
@LeetCode(value = 76, difficulty = Difficulty.HARD)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.SlidingWindow)
public class MinimumWindowSubstring {

    /**
     * This is an interesting problem, we have to count all elements which are available in child string.
     *
     * @param s parent string which might contain the child string values
     * @param t child string
     * @return minimum sub string which contains
     */
    public String minWindow(String s, String t) {
        if(t.length() > s.length())
            return "";
        // create hash of the smaller string
        int[] hash = new int[256];
        for(char c : t.toCharArray()) hash[c]++;

        int left = -1; int right =0; int count = t.length();

        String res = "";
        char[] sArr = s.toCharArray();
        while(right< sArr.length && left < sArr.length) {
            // if character is present in array, we subtract counter by 1. Until we reach counter.
            if(hash[sArr[right]]-- >= 1) {
                if(left == -1) {
                    left = right;
                }
                count--;
            }
            // if count is zero, we can take the sub string to be the most possible candidate.
            if(count == 0) {
                // since we have taken a sub string of left to right, we can ignore the left from string.
                // until count is still 0, we keep on trying to subtract the left most element from this,
                // and check to see if there is a sub string smaller than original, or
                // when we lose one element from the count
                while(count==0) {
                    if(res.equals("") || right+1-left < res.length())
                        res = s.substring(left, right+1);
                    if(hash[sArr[left++]]++ == 0)
                        count++;
                }
            }
            right++;
        }

        return res;
    }

}
