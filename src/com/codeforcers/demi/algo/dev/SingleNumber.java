package com.codeforcers.demi.algo.dev;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * There is a single number in an array full of elements with pairs. Pairs being the kep point, each number will be
 * appearing twice or multiples of two, except for one element.
 */
@LeetCode(value = 136, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Special)
public class SingleNumber {

    /**
     * This purely depends on the property of XOR, which is that,
     * <p></p>
     *      1. 0 XOR x = x
     * <p></p>
     *      2. x XOR x = 0
     * <p></p>
     * As we can see we can start with 0, and when we do XOR of all elements, we will arrive at a point, where we are
     * left out with only one element
     *
     * @param array array
     * @return single element
     */
    public int solve(int[] array) {
        int x = 0;
        for(int a : array){ x^=a; }
        return x;
    }

}