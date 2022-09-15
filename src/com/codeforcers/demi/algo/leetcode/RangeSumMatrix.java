package com.codeforcers.demi.algo.leetcode;

import com.codeforcers.demi.annotation.CodeFactor;
import com.codeforcers.demi.annotation.Difficulty;
import com.codeforcers.demi.annotation.LeetCode;
import com.codeforcers.demi.enums.Complexity;
import com.codeforcers.demi.enums.ProblemType;
import com.codeforcers.demi.util.Helper;

@LeetCode(value = 304, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ONPlusM, time = Complexity.O1, type = ProblemType.PrefixSum)
public class RangeSumMatrix {

    private final int[][] sumMatrix;

    /**
     * This method will do the heavy lifting of calculating the prefix sum of the matrix
     * @param matrix input matrix
     */
    public RangeSumMatrix(int[][] matrix) {
        sumMatrix = new int[matrix.length][matrix[0].length];

        for(int i=0; i<matrix.length; i++) {
            for(int j=0; j< matrix[0].length; j++) {
                sumMatrix[i][j] =
                          find(i-1,   j)
                        + find(i  , j-1)
                        - find(i-1, j-1)
                        + matrix[i][j];
            }
        }
        Helper.print(sumMatrix);
    }

    private int find(int row, int col) {
        if(row >=0 && row < this.sumMatrix.length && col >=0 && col < this.sumMatrix[0].length) {
            return this.sumMatrix[row][col];
        }
        return 0;
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return this.sumMatrix[row2][col2]
                - find(row1-1, col2)
                - find(row2, col1-1)
                + find(row1-1, col1-1);
    }
}
