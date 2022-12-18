package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Stack;

/**
 * Given an array of integers temperatures represents the daily temperatures,
 * return an array answer such that answer[i] is the number of days
 * you have to wait after the ith day to get a warmer temperature.
 * <p></p>
 * If there is no future day for which this is possible, keep answer[i] == 0 instead.
 */
@LeetCode(value = 739, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.SlidingWindow)
public class DailyTemperature {

    public int[] dailyTemperatures(int[] temperatures) {
        int[] res = new int[temperatures.length];
        Stack<Integer> temps = new Stack<>();

        for(int index = 0; index < temperatures.length; index++) {
            while(!temps.isEmpty() && temperatures[index] > temperatures[temps.peek()]) {
                res[temps.peek()] = index - temps.peek();
                temps.pop();
            }
            temps.push(index);
        }
        return res;
    }

}
