package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;
import com.codeforcers.demi.util.Helper;

@LeetCode(value = 768, difficulty = Difficulty.HARD)
@CodeFactor(space = Complexity.O1, time = Complexity.ONFact, type = ProblemType.TwoPointer)
public class MaxChunkSorted2 {

    public int maxChunksToSorted(int[] arr) {
        return maxChunksToSorted(arr, 0, arr.length-1);
    }

    private int maxChunksToSorted(int[] arr, int left, int right) {
        if(right == left) return 1;
        if(left > right) return 0;

        System.out.printf("-----\nAnalyzing chunk [%d[%d] %d[%d]]\n-----\n", arr[left], left, arr[right], right);
        int[] midMax = this.findMinMax(arr, left, right);
        if(midMax[1] < midMax[0]) return 1;
        if(midMax[1] == midMax[0]) return right - left+1;

        int[][] minMax = new int[3][2];
        minMax[0] = this.findMinMax(arr, left, midMax[0]+1);
        minMax[1] = this.findMinMax(arr, midMax[0]+1, midMax[1]);
        minMax[2] = this.findMinMax(arr, midMax[1], right);

        Helper.print(minMax, arr);
        int chunks = 0;
        if(minMax[1] == null || arr[minMax[0][1]] <= arr[minMax[1][0]]) {
            System.out.printf("-----\nChunk found left [%d[%d] %d[%d]]\n-----\n", arr[left], left, arr[minMax[0][0]], minMax[0][0]);
            chunks += maxChunksToSorted(arr, left, minMax[0][0]);
        }
        if(minMax[1] == null || arr[minMax[1][1]] <= arr[minMax[2][0]]) {
            System.out.printf("-----\nChunk found right [%d[%d] %d[%d]]\n-----\n", arr[minMax[2][0]], minMax[2][0], arr[right-1], right-1);
            chunks += maxChunksToSorted(arr, minMax[2][0], right);
        }
        if(minMax[1] != null && arr[minMax[0][1]] <= arr[minMax[1][0]] && arr[minMax[1][1]] <= arr[minMax[2][0]]) {
            System.out.printf("-----\nChunk found middle [%d[%d] %d[%d]]\n-----\n", arr[minMax[0][0]], minMax[0][0], arr[minMax[2][0]], minMax[2][0]);
            chunks += maxChunksToSorted(arr, minMax[0][0]+1, minMax[2][1]-1);
        } else {
            if(minMax[1]!= null)
                chunks+=1;
        }
        return chunks == 0 ? 1 : chunks;
    }

    private int[] findMinMax(int[] arr, int left, int right) {
        if (left > right)
            return null;

//        System.out.println("Left index "+left+" right index "+right);
        int min = left, max = right-1;
        for(int i=left; i<=right; i++) {
            if(arr[min] >= arr[i]) min = i;
            if(arr[max] <= arr[i]) max = i;
        }
//        System.out.println("Max "+arr[min]+" min "+arr[max]);
        return new int[]{min, max};
    }

}
