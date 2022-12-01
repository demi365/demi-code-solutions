package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * You are given a string s of even length. Split this string into two halves of equal lengths,
 * and let a be the first half and b be the second half.
 *<p></p>
 * Two strings are alike if they have the same number of vowels
 * {@code ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U')}.
 * <p></p>
 * Notice that s contains uppercase and lowercase letters.
 *<p></p>
 * Return true if a and b are alike. Otherwise, return false.
 */
@LeetCode(value = 1704, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.StringManipulation)
public class AlikeString {

    private static final Set<Character> VOWELS = new HashSet<>(Arrays.asList( 'a','e','i','o','u', 'A', 'E', 'I', 'O', 'U'));

    public boolean halvesAreAlike(String s) {
        int vowelCount = 0;
        for(int i=0; i<s.length()/2; i++) {
            if(VOWELS.contains(s.charAt(i))) vowelCount++;
        }
        for(int i=s.length()/2; i<s.length(); i++) {
            if(VOWELS.contains(s.charAt(i))) vowelCount--;
        }
        return vowelCount==0;
    }
}
