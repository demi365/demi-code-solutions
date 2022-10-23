package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * A conveyor belt has packages that must be shipped from one port to another within days days.
 * <p></p>
 * The ith package on the conveyor belt has a weight of weights[i].
 * Each day, we load the ship with packages on the conveyor belt (in the order given by weights).
 * We may not load more weight than the maximum weight capacity of the ship.
 * <p></p>
 * Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within days days.
 */
@LeetCode(value = 1011, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ONlogN, type = ProblemType.BinarySearch)
public class CapacityToShipWithinDDays {

    public int shipWithinDays(int[] weights, int days) {
        int max = weights[0];
        int min = weights[0];
        for (int i =1; i<weights.length; i++) {
            max += weights[i];
            min = Math.max(min, weights[i]);
        }

        if(days == 1)
            return max;

        while (min < max) {
            int mid = min + (max-min)/2;
            boolean ship = isGoodFit(weights, days, mid);
            // System.out.println("For weight "+mid+", we can ship goods in "+ship);
            if (ship) {
                max = mid;
            } else {
                min = mid+1;
            }
        }
        return min;
    }

    public boolean isGoodFit(int[] weights, int days, int capacity) {
        int sum = 0;
        int count = 1;

        for(int weight : weights) {
            sum += weight;
            if(sum > capacity) {
                count++;
                sum = weight;
                if (count > days)
                    return false;
            }
        }

        return true;
    }

}
