package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given an array of n strings strs, all of the same length.
 *<p></p>
 * The strings can be arranged such that there is one on each line, making a grid.
 * <p>
 *     ou want to delete the columns that are not sorted lexicographically.
 *     Example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted while column 1 ('b', 'c', 'a') is not, so you would delete column 1.
 * </p>
 */
@LeetCode(value = 944, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.StringManipulation)
public class DeleteToSort {

    public int minDeletionSize(String[] strs) {
        int count = 0;

        for (int i =0; i< strs[0].length(); i++) {
            for(int j =1; j< strs.length; j++) {
                if(strs[j].charAt(i) < strs[j-1].charAt(i)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }

}
