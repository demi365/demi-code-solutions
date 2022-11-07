package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given a positive integer num consisting only of digits 6 and 9.
 *<p></p>
 * Return the maximum number you can get by changing at most one digit (6 becomes 9, and 9 becomes 6).
 */
@LeetCode(value = 1323, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Math)
public class Maximum69Number {

    public int maximum69Number(int num) {
        int sixPlace = 0;
        int count = 1;
        int val = num;
        while(val > 0) {
            if(val%10==6)
                sixPlace = count;
            val/=10;
            count++;
        }

        if(sixPlace != 0) {
            return num + 3*(int) Math.pow(10, sixPlace-1);
        }

        return num;

    }

}
