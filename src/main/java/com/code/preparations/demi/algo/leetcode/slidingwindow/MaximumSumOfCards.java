package com.code.preparations.demi.algo.leetcode.slidingwindow;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * There are several cards arranged in a row, and each card has an associated number of points. The points are given in the integer array cardPoints.
 * <p></p>
 * In one step, you can take one card from the beginning or from the end of the row. You have to take exactly k cards.
 * <p></p>
 * Your score is the sum of the points of the cards you have taken.
 * <p></p>
 * Given the integer array cardPoints and the integer k, return the maximum score you can obtain.
 */
@LeetCode(value = 1423, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.SlidingWindow)
public class MaximumSumOfCards {

    /**
     * Assume that the first k elements add up to the total max sum.
     * Then try going by adding from the right most index one element and then subtract one from the last sum value.
     * Until we reach the sweet sum spot, and when we have the expected sum, we can return.
     *
     * @param cardPoints cards array
     * @param k k elements to be picked
     * @return max points which can be obtained
     */
    public int maxScore(int[] cardPoints, int k) {
        int maxSum = 0;
        for(int i=0; i<k; i++) {
            maxSum+=cardPoints[i];
        }
        int prevSum = maxSum;
        for(int i=cardPoints.length-1; i>=(cardPoints.length)-k; i--) {
            prevSum = prevSum - cardPoints[i-(cardPoints.length-1)+(k-1)] + cardPoints[i];
            maxSum = Math.max(prevSum, maxSum);
        }
        return maxSum;
    }

}
