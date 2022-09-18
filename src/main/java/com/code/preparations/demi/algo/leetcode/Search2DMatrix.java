package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;
import com.code.preparations.demi.annotation.CodeFactor;

@LeetCode(value = 240, difficulty = Difficulty.MEDIUM)
@CodeFactor(space = Complexity.O1, time = Complexity.ONPlusM, type = ProblemType.TwoDMatrix)
public class Search2DMatrix {

    public static boolean searchMatrix(int[][] matrix, int target) {
        if(target < matrix[0][0]) return false;
        if(target == matrix[0][0]) return true;
        int dir = 0;
        int row = 0, col = 0;
        int[][] dirMat = {{0,1},{1,0},{0,-1},{-1,0}};
        int count = 0;
        int len = matrix.length * matrix[0].length;

        while(count++ <= len) {
            if(dir >= 4) {
                return false;
            }
            int[] curDir = dirMat[dir];
            int nextRow = row+curDir[0];
            int nextCol = col+curDir[1];
            // System.out.println("Comparing with row = "+nextRow+", col = "+nextCol+", val = "+matrix[nextRow][nextCol]);
            if(!validIndex(nextRow, nextCol, matrix)) {
                dir++;
                continue;
            } else if(matrix[nextRow][nextCol] == target) {
                return true;
            } else if(dir <2 && matrix[nextRow][nextCol] > target) {
                dir+=1;
            } else if(dir >= 2 && matrix[nextRow][nextCol] < target) {
                dir+=1;
            }
            row = nextRow;
            col = nextCol;
        }
        return false;
    }

    private static boolean validIndex(int row, int col, int[][] matrix) {
        return (row >= 0 && row < matrix.length)
                && (col >= 0 && col < matrix[0].length);
    }
}
