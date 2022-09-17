package com.codeforcers.demi.algo.dev;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

import java.util.Stack;

/**
 * Design an algorithm that collects daily price quotes for some stock and returns the span of that stock's price for the current day.
 *<p></p>
 * The span of the stock's price today is defined as the maximum number of consecutive days (starting from today and going backward) for which the stock price was less than or equal to today's price.
 *<p></p>
 * For example, if the price of a stock over the next 7 days were [100,80,60,70,60,75,85], then the stock spans would be [1,1,1,2,1,4,6].
 * Implement the StockSpanner class:
 * <p></p>
 * StockSpanner() Initializes the object of the class.
 * int next(int price) Returns the span of the stock's price given that today's price is price.
 */
@LeetCode(value = 901, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.PrefixSum)
public class StockSpanner {

    private final Stack<int[]> stack;

    public StockSpanner() {
        stack = new Stack<>();
    }

    /**
     * The algorithm looks like prefix sum, where the sum is done with multiple different chunks.
     * We start storing the ones which were consecutive to current price.
     * <p></p>
     * In the stack we are storing the values based on the current max price and the previous max price and their corresponding streak.
     * This way when we see a stack of [100(1), 80(1), 70(2), 65(2)], and when we see 80. We can confirm that previously there
     * are 65(2) + 70(2) + 80(1) = 5 and replace the entire streak with new 80(6)
     *
     * @param price current price
     * @return the consecutive number of days in which the price was less than or equal to current date.
     */
    public int next(int price) {
        int count = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            int[] topPrice = stack.pop();
            count += topPrice[1];
        }
        stack.push(new int[]{price, count});
        System.out.println("Price "+price+" count "+count);
        return count;
    }

}
