package com.code.preparations.demi.algo.leetcode.math;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * There are n gas stations along a circular route, where the amount of gas at the ith station is gas[i].
 *<p></p>
 * You have a car with an unlimited gas tank, and
 * it costs <code>cost[i]</code> of gas to travel from the ith station to its next (i + 1)th station.
 * You begin the journey with an empty tank at one of the gas stations.
 *<p></p>
 * Given two integer arrays gas and cost, return the starting gas station's index
 * if you can travel around the circuit once in the clockwise direction,
 * otherwise return -1. If there exists a solution,
 * it is guaranteed to be unique
 */
@LeetCode(value = 138, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.Math)
public class GasStation {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int candidate = 0;
        int count = 0;
        int sum = 0;
        for (int i = 0; i < gas.length * 2; i++) {
            sum += gas[i % gas.length] - cost[i % gas.length];
            if (sum < 0) {
                candidate = i + 1;
                sum = 0;
                count = 0;
            } else {
                count++;
                if (count >= gas.length) {
                    return candidate;
                }
            }
        }
        return -1;
    }

}
