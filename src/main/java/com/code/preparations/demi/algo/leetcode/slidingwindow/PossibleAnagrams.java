package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.emptyList;

/**
 * Given two strings s and p, return an array of all the start indices of p's anagrams in s. You may return the answer in any order.
 *<p></p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 */
@LeetCode(value = 438, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.SlidingWindow)
public class PossibleAnagrams {

    /**
     * Possible anagrams of a string p in a string s.
     * Here we think of it this way, we have a counter of which elements are in p.
     * We create a map and count the number of occurrences of p and give them a heads-up so that they can be positive.
     * <p>
     *      Then we start sliding from one point left to another point right. Create a counter for number of elements to
     *      be found, which is p length.
     *      We start subtracting elements present in s from this newly created hash, and also decrease the counter when
     *      the element is present in string p. i.e, when it is positive.
     *      If left and right are pointing to two ends of the string s, where p length matches,
     *      i.e, when the sub string length matches the p string length, we remove the left most element hash value and
     *      increment the counter.
     *      In this loop if count ever reaches zero, we can be sure that the left index will point to the start index
     *      of this sub string where the anagram exists.
     * </p>
     */
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())
            return emptyList();

        int pLen = p.length(); int sLen = s.length();

        int[] hash = new int[128];
        for(int i =0; i< pLen; i++) {
            hash[p.charAt(i)]++;
        }

        List<Integer> result = new ArrayList<>();
        int left =0; int right = 0; int count = pLen;
        while(right<sLen) {
            if(hash[s.charAt(right++)]-- >= 1) {
                count--;
            }

            if(count == 0)
                result.add(left);

            if(right - left == pLen) {
                if(hash[s.charAt(left++)]++ >= 0) {
                    count++;
                }
            }
        }
        return result;
    }
}
