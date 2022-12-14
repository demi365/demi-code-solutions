package com.code.preparations.demi.algo.leetcode;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given an m x n binary matrix mat, return the number of special positions in mat.
 *<p></p>
 * A position (i, j) is called special if mat[i][j] == 1 and all other elements in row i and column j are 0 (rows and columns are 0-indexed).
 */
@LeetCode(value = 1582, difficulty = Difficulty.EASY)
@CodeFactor(space = Complexity.ONPlusM, time = Complexity.ONM, type = ProblemType.TwoDMatrix)
public class SpecialNumberInMatrix {

    /**
     * Iterate overs the matrix and
     * @param mat matrix to check
     * @return number of special numbers
     */
    public static int numSpecial(int[][] mat) {
        int sum = 0;
        int[] row = new int[mat.length];
        int[] col = new int[mat[0].length];

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i< mat.length; i++) {
            for(int j=0; j< mat[0].length; j++) {
                if(mat[i][j] == 1) {
                    row[i] += 1;
                    col[j] += 1;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] candidate = queue.poll();
            if(row[candidate[0]] == 1 && col[candidate[1]] == 1)
                sum+=1;
        }

        return sum;
    }

}
