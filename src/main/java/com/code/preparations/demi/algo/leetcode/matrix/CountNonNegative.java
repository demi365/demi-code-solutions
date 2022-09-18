package com.code.preparations.demi.algo.leetcode.matrix;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise,
 * return the number of negative numbers in grid.
 */
@LeetCode(value = 1351, difficulty = Difficulty.EASY)
@CodeFactor(time = Complexity.ONPlusM, space = Complexity.O1, type= ProblemType.Matrix)
public class CountNonNegative {

    /**
     * Iterate from top last column, and see if any negative is found, if found, see how many negatives are there in
     * this row, and if we can't find negative, add this number to the sum,
     * and move on to next row, continue same for N+M traversal at most.
     *
     * @param grid input grid
     * @return count of negative elements
     */
    public int countNegatives(int[][] grid) {
        if(grid[grid.length-1][grid[0].length-1] >=0)
            return 0;
        if(grid[0][0] < 0) return grid.length*grid[0].length;

        int row = 0;
        int col = grid[0].length-1;

        int sum = 0;
        while(row < grid.length) {
            while(col >=0 && grid[row][col] <0) {
                col--;
            }
            sum += grid[0].length-col-1;
            row++;
        }

        return sum;
    }

}
