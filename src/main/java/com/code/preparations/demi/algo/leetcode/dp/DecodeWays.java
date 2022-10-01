package com.code.preparations.demi.algo.leetcode.dp;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * A message containing letters from A-Z can be encoded into numbers using the following mapping:
 * <p></p> 'A' -> "1"
 * <p></p> 'B' -> "2"
 * <p></p> ...
 * <p></p> 'Z' -> "26"
 * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of
 * the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
 *
 * <p></p>
 * "AAJF" with the grouping (1 1 10 6)
 * <p></p>
 * "KJF" with the grouping (11 10 6)
 * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
 *<p></p>
 * Given a string s containing only digits, return the number of ways to decode it.
 *<p></p>
 * The test cases are generated so that the answer fits in a 32-bit integer.
 */
@LeetCode(value = 91, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON,type = ProblemType.DynamicProgramming)
public class DecodeWays {

    /**
     * Classic dp problem, where we take the number of ways in which the words can be formed, and the sum of ways in
     * which the word can be formed is eventually added for the number of ways the remaining sub section can be added
     */
    public int numDecodings(String s) {
        if (s.charAt(0) == '0')
            return 0;
        return numDecode(s, 0, new int[s.length()]);
    }

    public int numDecode(String s, int startIndex, int[] dp) {
        if(startIndex >= s.length())
            return 1;

        int sum = 0;
        int charS = s.charAt(startIndex)-'0';

        if(dp[startIndex] != 0) {
            // System.out.println("DP return "+dp[startIndex]);
            return dp[startIndex];
        }

        if(charS != 0) {
            sum += numDecode(s, startIndex + 1, dp);
            if(startIndex+1 < s.length())  {
                int charT = charS*10 + (s.charAt(startIndex+1)-'0');
                if(charT <= 26) {
                    sum += numDecode(s, startIndex + 2, dp);
                }
            }
        }

        dp[startIndex] = sum;

        return sum;
    }

}
