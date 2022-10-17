package com.code.preparations.demi.algo.leetcode.bit;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * You are given an array arr of positive integers. You are also given the array queries where queries[i] = [lefti, righti].
 *<p></p>
 * For each query i compute the XOR of elements from lefti to righti (that is, arr[lefti] XOR arr[lefti + 1] XOR ... XOR arr[righti] ).
 *<p></p>
 * Return an array answer where answer[i] is the answer to the ith query.
 */
@LeetCode(value = 1310, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ON, space = Complexity.ON, type = ProblemType.BitManipulation)
public class XORSubQueries {

    /**
     * Xor queries on the sub query, the logic is we store them in a prefix sum and then whenever there is a need
     * we can pick xor the sub array between start and end to arrive at the answer
     */
    public int[] xorQueries(int[] arr, int[][] queries) {
        int[] val = new int[queries.length];
        int[] xors = new int[arr.length+1];
        xors[0] = 0;
        for(int i = 0; i<arr.length; i++) {
            xors[i+1] = xors[i] ^ arr[i];
        }
        for(int i = 0; i<queries.length; i++) {
            val[i] = xors[queries[i][0]] ^ xors[queries[i][1]+1];
        }
        return val;
    }

}
