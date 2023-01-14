package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given two strings of the same length s1 and s2 and a string baseStr.
 *<p></p>
 * We say s1[i] and s2[i] are equivalent characters.
 *<p></p>
 * For example, if s1 = "abc" and s2 = "cde", then we have 'a' == 'c', 'b' == 'd', and 'c' == 'e'.
 *<p></p>
 * Equivalent characters follow the usual rules of any equivalence relation:
 *<p></p>
 * Reflexivity: 'a' == 'a'.
 *<p></p>
 * Symmetry: 'a' == 'b' implies 'b' == 'a'.
 *<p></p>
 * Transitivity: 'a' == 'b' and 'b' == 'c' implies 'a' == 'c'.
 *<p></p>
 * For example, given the equivalency information from s1 = "abc" and s2 = "cde", "acd" and "aab" are equivalent strings of baseStr = "eed", and "aab" is the lexicographically smallest equivalent string of baseStr.
 *<p></p>
 * Return the lexicographically smallest equivalent string of baseStr by using the equivalency information from s1 and s2.
 */
@LeetCode(value = 1061, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.StringManipulation)
public class LexicographicalSmallestString {

    public String smallestEquivalentString(String s1, String s2, String baseStr) {

        char[] group = new char[26];

        for(int i=0; i<26; i++)
            group[i] = (char) ((int) 'a' + i);
        for(int i=0; i<s1.length(); i++) {
            map(s1.charAt(i), s2.charAt(i), group);
        }

        char[] res = new char[baseStr.length()];
        for(int i=0; i<baseStr.length(); i++) {
            res[i] = parent(baseStr.charAt(i), group);
        }

        return new String(res);
    }

    public void map(char c1, char c2, char[] group) {
        if(c1 > c2) {
            map(c2, c1, group);
        } else if (c1 < c2) {
            if(group[c2-'a'] != c2) {
                map(group[c2-'a'], c1, group);
            } else {
                group[c2-'a'] = c1;
            }
        }
    }

    public char parent(char root, char[] group) {
        if(group[root-'a'] == root) {
            return root;
        } else {
            return parent(group[root-'a'], group);
        }
    }
}
