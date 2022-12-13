package com.code.preparations.demi.algo.leetcode.dp;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
 *<p></p>
 * A falling path starts at any element in the first row and chooses the element in the next row
 * that is either directly below or diagonally left/right.
 * <p></p>
 * Specifically, the next element from position {@code row, col} will be
 * {@code row + 1, col - 1}, {@code row + 1, col}, or {@code row + 1, col + 1}
 */
@LeetCode(value = 931, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONM, space = Complexity.ONM, type = ProblemType.TwoDMatrix)
public class MinFallingPath {

    public int minFallingPathSum(int[][] matrix) {
        int ans = Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];

        for (int col = 0; col < matrix[0].length; col++) {
            ans = Math.min(
                    ans,
                    this.minPath(matrix, 0, col, dp)
            );
        }

        return ans;
    }

    public int minPath(int[][] matrix, int row, int col, int[][] dp) {

        if(dp[row][col] != 0) {
            return dp[row][col];
        }

        if(row == matrix.length-1) {
            return matrix[row][col];
        }

        int min = Integer.MAX_VALUE;

        if(col != 0) {
            int left = this.minPath(matrix, row+1, col-1, dp);
            min = Math.min(left + matrix[row][col], min);
        }

        if(col != matrix[row].length-1) {
            int right = this.minPath(matrix, row+1, col+1, dp);
            min = Math.min(right + matrix[row][col], min);
        }

        int current = this.minPath(matrix, row+1, col, dp);
        min = Math.min(current + matrix[row][col], min);

        dp[row][col] = min;

        return dp[row][col];
    }

}
