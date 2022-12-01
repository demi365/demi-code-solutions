package com.code.preparations.demi.algo.leetcode.string;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given a string s and an integer k, a k duplicate removal consists of choosing k adjacent
 * and equal letters from s and removing them, causing the left and the right side of the deleted substring to concatenate together.
 *<p></p>
 * We repeatedly make k duplicate removals on s until we no longer can.
 *<p></p>
 * Return the final string after all such duplicate removals have been made.
 * It is guaranteed that the answer is unique.
 */
@LeetCode(value = 1209, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.StringManipulation)
public class RemoveDuplicate {

    public String removeDuplicates(String s, int k) {
        List<List<Integer>> values = new ArrayList<>();
        for(char element : s.toCharArray()) {
            if(values.isEmpty() || values.get(values.size()-1).get(0) != element) {
                values.add(Arrays.asList((int) element, 1));
            } else {
                List<Integer> lastChar = values.get(values.size()-1);
                if(lastChar.get(0) == element && lastChar.get(1)+1 == k) {
                    values.remove(values.size()-1);
                } else {
                    values.remove(values.size()-1);
                    values.add(Arrays.asList((int) element, lastChar.get(1)+1));
                }
            }
        }
        // System.out.println(values);
        StringBuilder str = new StringBuilder();
        for (List<Integer> uniques : values) {
            int count = uniques.get(1);
            char c = (char) uniques.get(0).intValue();
            while(count > 0) {
                str.append(c);
                count--;
            }
        }
        return str.toString();
    }
}
