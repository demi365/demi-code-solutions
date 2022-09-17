package com.codeforcers.demi.algo.dev;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;

/**
 * Find the maximum sub array of the given array
 */
@LeetCode(value = 53, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.O1, type = ProblemType.Special)
public class MaximumSubArray {

    /**
     * This is Kadane's Algorithm, the solution or basic idea is the maximum at any given point will
     * either be the current element itself or sum of previously found elements.
     * <p></p>
     * i.e, if the current element is 10, and the sum until the previous elements is coming up to -2, then if I add this to
     * 10, the sum at this point will become 8, which is less than current element, then my starting point is set to
     * current element.
     * <p></p>
     * This way we can gloss over the entire list of elements in O(n) and find the maximum sub array size
     *
     * @param array input array
     * @return maximum sum of the sub array
     */
    public int solve(int[] array) {
        int globMax = array[0];
        int currMax = array[0];
        for(int x : array) {
            currMax = Math.max(x, currMax+x);
            if(currMax > globMax) {
                globMax = currMax;
            }
        }

        return globMax;
    }

}
