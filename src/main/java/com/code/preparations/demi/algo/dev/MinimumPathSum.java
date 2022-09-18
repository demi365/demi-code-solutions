package com.code.preparations.demi.algo.dev;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given an m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.
 *<p></p>
 * Note: You can only move either down or right at any point in time.
 * This solution only applies when there is a two-way restriction on how to traverse
 */
@LeetCode(value = 64, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.ONM, time = Complexity.ONM, type = ProblemType.DynamicProgramming)
public class MinimumPathSum {

    /**
     * We have to analyze each and every possible way before making a commitment on which could be the possible solution.
     * Hence, the one potential way to solve this is using dynamic programming.
     *
     * @param grid input array
     * @return minimum sum possible
     */
    public int minPathSum(int[][] grid) {
        return minPathSum(grid, new int[grid.length][grid[0].length], 0, 0);
    }

    public int minPathSum(int[][] grid, int[][] dp, int i, int j) {
        if(i == grid.length-1 && j == grid[0].length-1)
            return grid[i][j];

        if(dp[i][j] != 0)
            return dp[i][j];
        int down = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        if(i!= grid.length-1)
            down = grid[i][j] + minPathSum(grid, dp, i+1, j);
        if(j!= grid[0].length-1)
            left = grid[i][j] + minPathSum(grid, dp, i, j+1);

        dp[i][j] = Math.min(down, left);

        return dp[i][j];

    }

}
