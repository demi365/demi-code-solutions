package com.code.preparations.demi.algo.leetcode.sort;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;

/**
 * It is a sweltering summer day, and a boy wants to buy some ice cream bars.
 *<p></p>
 * At the store, there are n ice cream bars. You are given an array costs of length n,
 * where costs[i] is the price of the ith ice cream bar in coins. The boy initially has <code>coins</code> coins to spend,
 * and he wants to buy as much ice cream bars as possible.
 *<p></p>
 * Return the maximum number of ice cream bars the boy can buy with <code>coins</code> coins.
 *<p></p>
 * Note: The boy can buy the ice cream bars in any order.
 */
@LeetCode(value = 1833, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Sorting)
public class MaxIceCreams {

    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int cost : costs) {
            if(cost <= coins && coins >= 0) {
                count++;
                coins -= cost;
            } else {
                break;
            }
        }
        return count;
    }

}
