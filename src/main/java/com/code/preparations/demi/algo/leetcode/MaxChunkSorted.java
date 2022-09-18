package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given an integer array arr of length n that represents a permutation of the integers in the range [0, n - 1].
 * <p></p>
 * We split arr into some number of chunks (i.e., partitions), and individually sort each chunk. After concatenating them, the result should equal the sorted array.
 * <p></p>
 * Return the largest number of chunks we can make to sort the array.
 */
@LeetCode(value = 769, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ON, type = ProblemType.Matrix)
public class MaxChunkSorted {

    /**
     * The idea behind this is that, as long as all numbers from (k to n) appear within the range (k to n), we can split
     * it into chunks.
     * <p></p>
     * Essentially three cases
     * <p></p>
     * 1. If the index matches the number and there was no previous abnormalities in indexes, then we can split this as a chunk.
     * <p></p>
     * 2. On finding one maximum, if there is another maximum found within the same index range, before reaching the prev max end range,
     * maximum as to be reset.
     * <p></p>
     * 3. If the previous anomaly is now equal to the current index, we can set the anomaly has fixed.
     */
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0;
        boolean largestFound = false;
        int largest = 0;
        for(int i = 0; i < arr.length; i++) {
            if(!largestFound && arr[i] == i) {
                chunks++;
            } else if(arr[i] > i) {
                largestFound = true;
                largest = Math.max(largest, arr[i]);
            } else if(largestFound) {
                if(i==largest) {
                    largestFound = false;
                    largest = 0;
                    chunks++;
                }
            }
        }
        return chunks;
    }

}
