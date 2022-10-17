package com.code.preparations.demi.algo.leetcode.search;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.Arrays;

/**
 * In the universe Earth C-137, Rick discovered a special form of magnetic force between two balls if they are put in
 * his new invented basket. Rick has n empty baskets, the ith basket is at position[i],
 * Morty has m balls and needs to distribute the balls into the baskets such that
 * the minimum magnetic force between any two balls is maximum.
 *<p></p>
 * Rick stated that magnetic force between two different balls at positions x and y is |x - y|.
 *<p></p>
 * Given the integer array position and the integer m. Return the required force.
 */
@LeetCode(value = 1552, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONlogN, space = Complexity.O1, type = ProblemType.BinarySearch)
public class MagneticForce {

    /**
     * This takes up O(1) space and has the unique property of iterating through the possible answers from 1 to max answer.
     * Max answer = diff between max value and minimum value, the smallest answer possible is 1.
     */
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);
        int left = 1; int right = (position[position.length - 1] - position[0])/(m-1);

        int lastAns = 0;
        // System.out.println("Search between "+left+" and "+right);

        while(left <= right) {
            int mid = left+(right-left)/2;
            boolean isFeasible = isGoodFit(position, mid, m);
            if(isFeasible) {
                lastAns = mid;
                left = mid+1;
            } else {
                right = mid-1;
            }
        }

        return lastAns;
    }

    public boolean isGoodFit(int[] position, int value, int fit) {

        int count = 1;
        int lastPosition = position[0];
        // System.out.println("For value "+value+" total fit needed = "+fit);
        for(int pos : position) {
            if(pos-lastPosition >= value) {
                count++;
                lastPosition = pos;
                if(count == fit)
                    return true;
            }
        }
        // System.out.println("For value "+value+" total fit found = "+count);
        return count == fit;
    }
}
