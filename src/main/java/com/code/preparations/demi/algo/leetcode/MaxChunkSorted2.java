package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

@LeetCode(value = 768, difficulty = Difficulty.HARD)
@CodeFactor(space = Complexity.ON, time = Complexity.ON, type = ProblemType.TwoPointer)
public class MaxChunkSorted2 {

    /**
     * The basic concept is when the left maximum, is less than the right minimum, it is automatically qualified to
     * be created as a new chunk.
     *
     * @param arr input array
     * @return maximum number of chunks
     */
    public int maxChunksToSorted(int[] arr) {
        int[] leftMax = new int[arr.length];
        int[] rightMin = new int[arr.length];

        leftMax[0] = arr[0];
        for(int i=1; i< arr.length; i++) {
            leftMax[i] = Math.max(arr[i], leftMax[i-1]);
        }
        rightMin[arr.length-1] = arr[arr.length-1];
        for(int i=arr.length-2; i>=0; i--) {
            rightMin[i] = Math.min(arr[i], rightMin[i+1]);
        }

        int res=1;
        for(int i=0; i<arr.length-1; i++) {
            if(leftMax[i] <= rightMin[i+1]) res++;
        }
        return res;
    }

}
