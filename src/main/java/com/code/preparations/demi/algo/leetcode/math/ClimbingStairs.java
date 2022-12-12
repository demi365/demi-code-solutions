package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are climbing a staircase. It takes n steps to reach the top.
 *<p></p>
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
@LeetCode(value = 70, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Math)
public class ClimbingStairs {

    public int climbStairs(int n) {
        if(n <= 2) return n;

        int[] steps = new int[3];
        for(int i=0; i<3;i++) steps[i] = i;

        for(int i=2; i<n; i++){
            steps[0] = steps[1] + steps[2];
            steps[1] = steps[2];
            steps[2] = steps[0];
        }
        return steps[0];
    }

}
