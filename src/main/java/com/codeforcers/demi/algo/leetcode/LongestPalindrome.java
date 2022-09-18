package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.Difficulty;
import com.codeforcers.demi.enums.ProblemType;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s which consists of lowercase or uppercase letters, return the length of the longest palindrome that can be built with those letters.
 *<p></p>
 * Letters are case-sensitive, for example, "Aa" is not considered a palindrome here.
 */
@LeetCode(value = 409, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.HashTable)
public class LongestPalindrome {

    /**
     * One of the Easy questions which made me lose hope on being a programmer. This was quite easy, but getting the logic
     * took me sometimes, while I considered that odd numbers can never be counted in the length, but we miss the point where
     * odd can be counted, but one of them had to be left out. So, That was mind opening and had to lose hope on my logical
     * skills
     *
     * @param s string with characters
     * @return size of the longest palindrome to be created
     */
    public int longestPalindrome(String s) {
        Map<Character, Integer> hash = new HashMap<>();
        for(char c : s.toCharArray()) {
            hash.put(c, hash.getOrDefault(c, 0)+1);
        }

        System.out.println(hash);
        int count = 0;
        boolean single = false;
        for(Integer val : hash.values()) {
            if(val%2==0) {
                count+=val;
            } else {
                count+=val-1;
                single = true;
            }
        }
        return single ? count+1 : count;
    }

}
