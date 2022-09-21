package com.code.preparations.demi.algo.leetcode.matrix;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.
 *<p></p>
 * You can either start from the step with index 0, or the step with index 1.
 *<p></p>
 * Return the minimum cost to reach the top of the floor.
 */
@LeetCode(value = 746, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ONM, space = Complexity.ONM, type = ProblemType.DynamicProgramming)
public class MinCostOfClimbingStairs {

    /**
     * We just start from one point, and keep iterating to search which is the most minimum cost.
     * This most optimized version will make use of dynamic programming to solve this
     */
    public int minCostClimbingStairs(int[] cost) {

        int[] costMat = new int[cost.length];
        return Math.min(
                minCost(cost, costMat, 0),
                minCost(cost, costMat, 1)
        );

    }

    public int minCost(int[] cost, int[] costMat, int start) {

        if(start == cost.length-2 || start == cost.length-1)
            return cost[start];
        if(start > cost.length-1)
            return 0;

        if(costMat[start] != 0)
            return costMat[start];

        int x = cost[start] + minCost(cost, costMat, start+1);
        int y = cost[start] + minCost(cost, costMat, start+2);

        costMat[start] = Math.min(x,y);

        return costMat[start];
    }
}
