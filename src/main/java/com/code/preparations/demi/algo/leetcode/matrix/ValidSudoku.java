package com.code.preparations.demi.algo.leetcode.matrix;

import com.code.preparations.demi.annotation.CodeFactor;
import com.code.preparations.demi.annotation.LeetCode;
import com.code.preparations.demi.enums.Complexity;
import com.code.preparations.demi.enums.Difficulty;
import com.code.preparations.demi.enums.ProblemType;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 *<p></p>
 * Each row must contain the digits 1-9 without repetition.
 * <p></p>
 * Each column must contain the digits 1-9 without repetition.
 * <p></p>
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * <p></p>
 * Note:
 *<p></p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 */
@LeetCode(value = 36, difficulty = Difficulty.MEDIUM)
@CodeFactor(time = Complexity.ONM, space = Complexity.ON, type = ProblemType.Matrix)
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {

        for(int i = 0; i< 9; i++) {
            int[] col = new int[]{0,0,0,0,0,0,0,0,0,0};
            int[] row = new int[]{0,0,0,0,0,0,0,0,0,0};
            int[] box = new int[]{0,0,0,0,0,0,0,0,0,0};
            for(int j=0; j<9; j++) {
                char boxC = board[(i/3)*3+j/3][(i%3)*3+j%3];
                char rowC = board[i][j];
                char colC = board[j][i];
                if(boxC != '.') {
                    box[ boxC - '0'] +=1;
                }
                if(rowC != '.') {
                    row[ rowC - '0'] +=1;
                }

                if(colC != '.') {
                    col[ colC - '0'] +=1;
                }
            }
            for(int j=0; j<=9; j++) {
                boolean valid = valid(box[j]) && valid(row[j]) && valid(col[j]);
                if(!valid)
                    return false;
            }
        }
        return true;
    }

    private boolean valid(int count) {
        return count==0 || count ==1;
    }
}
